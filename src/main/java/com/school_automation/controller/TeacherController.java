package com.school_automation.controller;

import com.school_automation.dto.CreateTeacherForm;
import com.school_automation.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TeacherController
{
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/teachers")
    public String gotoTeachers(Model model)
    {
        model.addAttribute("teachers", teacherService.getAll());
        model.addAttribute("createTeacherForm", new CreateTeacherForm());

        return "teachers";
    }

    @RequestMapping(value = "/teachers", method = RequestMethod.POST)
    public String gotoTeachers(@ModelAttribute CreateTeacherForm createTeacherForm)
    {
        teacherService.createTeacher(createTeacherForm);

        return "redirect:/teachers";
    }
}
