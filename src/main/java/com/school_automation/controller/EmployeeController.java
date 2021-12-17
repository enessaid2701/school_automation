package com.school_automation.controller;

import com.school_automation.entity.EmployeeEntity;
import com.school_automation.entity.StudentEntity;
import com.school_automation.form.CreateEmployeeForm;
import com.school_automation.form.CreateStudentForm;
import com.school_automation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;


    @PostMapping(value = "/create")
    private String createOrUpdateEmployee(@ModelAttribute CreateEmployeeForm createEmployeeForm){
        employeeService.createEmployee(createEmployeeForm);
        return "redirect:/admin/get-admin-employee";
    }

    @GetMapping(value = "/delete/{employeeId}")
    private String deleteEmployee(@PathVariable("employeeId") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return "redirect:/admin/get-admin-employee";
    }

    @GetMapping(value = "/{employeeId}")
    private String getEmployeeById(@PathVariable("employeeId") Long employeeId, Model model){

        EmployeeEntity employeeEntity = employeeService.getEmployeeById(employeeId);

        CreateEmployeeForm createEmployeeForm = new CreateEmployeeForm();

        createEmployeeForm.setName(employeeEntity.getName());
        createEmployeeForm.setJob(employeeEntity.getJob());
        createEmployeeForm.setId(employeeEntity.getId());

        model.addAttribute("employeeList", employeeService.getAll().stream().map(EmployeeEntity::toDTO).collect(Collectors.toList()));
        model.addAttribute("createEmployeeForm",createEmployeeForm);
        return "adminPanelEmployee";
    }

    @GetMapping
    private String getEmployeeById( Model model){
        model.addAttribute("employees",employeeService.getAll());
        return "employees";
    }

}
