package com.school_automation.controller;

import com.school_automation.dto.CreateStudentForm;
import com.school_automation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController
{
    @Autowired
    private StudentService studentService;

    @RequestMapping("/students")
    public String gotoStudents(Model model)
    {
        model.addAttribute("students", studentService.getAll());
        model.addAttribute("createStudentForm", new CreateStudentForm());

        return "students";
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public String gotoStudents(@ModelAttribute CreateStudentForm createStudentForm)
    {
        studentService.createStudent(createStudentForm);

        return "redirect:/students";
    }

}
