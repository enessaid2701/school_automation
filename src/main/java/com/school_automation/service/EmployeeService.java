package com.school_automation.service;

import com.school_automation.dto.CreateEmployeeForm;
import com.school_automation.dto.CreateStudentForm;
import com.school_automation.entity.EmployeeEntity;
import com.school_automation.entity.StudentEntity;
import com.school_automation.repository.EmployeeRepository;
import com.school_automation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    @PutMapping
    public void createEmployee(CreateEmployeeForm createEmployeeForm)
    {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setJob(createEmployeeForm.getJob());
        employeeEntity.setName(createEmployeeForm.getName());

        employeeRepository.save(employeeEntity);
    }

    @PostMapping
    public void updateEmployee(CreateEmployeeForm createEmployeeForm)
    {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setJob(createEmployeeForm.getJob());
        employeeEntity.setName(createEmployeeForm.getName());

        employeeRepository.save(employeeEntity);
    }

    @DeleteMapping
    public void deleteEmployee(CreateEmployeeForm createEmployeeForm)
    {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setJob(createEmployeeForm.getJob());
        employeeEntity.setName(createEmployeeForm.getName());

        employeeRepository.save(employeeEntity);
    }
}
