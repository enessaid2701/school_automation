package com.school_automation.service;

import com.school_automation.entity.StudentEntity;
import com.school_automation.form.CreateEmployeeForm;
import com.school_automation.entity.EmployeeEntity;
import com.school_automation.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeEntity> getAll()
    {
        Iterator<EmployeeEntity> employeesIt = employeeRepository.findAll().iterator();
        List<EmployeeEntity> employees = new ArrayList<>();

        employeesIt.forEachRemaining(employees::add);

        return employees;
    }

    public EmployeeEntity getEmployeeById(Long id){
        return employeeRepository.findById(id).get();
    }

    public void createEmployee(CreateEmployeeForm createEmployeeForm)
    {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setJob(createEmployeeForm.getJob());
        employeeEntity.setId(createEmployeeForm.getId());
        employeeEntity.setName(createEmployeeForm.getName());

        employeeRepository.save(employeeEntity);
    }

    public void updateEmployee(CreateEmployeeForm createEmployeeForm)
    {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setJob(createEmployeeForm.getJob());
        employeeEntity.setName(createEmployeeForm.getName());

        employeeRepository.save(employeeEntity);
    }

    public void deleteEmployee(Long id)
    {
        Optional<EmployeeEntity> employeeEntityOptional = employeeRepository.findById(id);
        employeeEntityOptional.ifPresent(employeeEntity -> employeeRepository.delete(employeeEntity));
    }
}
