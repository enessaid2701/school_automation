package com.school_automation.controller;

import com.school_automation.dto.CreateEmployeeForm;
import com.school_automation.service.EmployeeService;
import com.school_automation.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employees")
    public String gotoEmployees(Model model)
    {
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("createEmployeeForm", new CreateEmployeeForm());

        return "employees";
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public String gotoEmployees(@ModelAttribute CreateEmployeeForm createEmployeeForm)
    {
        employeeService.createEmployee(createEmployeeForm);

        return "redirect:/employees";
    }
}
