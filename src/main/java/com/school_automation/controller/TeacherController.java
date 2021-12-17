package com.school_automation.controller;

import com.school_automation.entity.TeacherEntity;
import com.school_automation.form.CreateTeacherForm;
import com.school_automation.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController
{
    @Autowired
    private TeacherService teacherService;


    @PostMapping(value = "/create")
    private String createOrUpdateTeacher(@ModelAttribute CreateTeacherForm createTeacherForm){
        teacherService.createTeacher(createTeacherForm);
        return "redirect:/admin/get-admin-teacher";
    }

    @GetMapping(value = "/delete/{teacherId}")
    private String deleteTeacher(@PathVariable("teacherId") Long teacherId){
        teacherService.deleteTeacher(teacherId);
        return "redirect:/admin/get-admin-teacher";
    }

    @GetMapping(value = "/{teacherId}")
    private String getTeacherById(@PathVariable("teacherId") Long teacherId, Model model){

        TeacherEntity teacherEntity = teacherService.getTeacherById(teacherId);

        CreateTeacherForm createTeacherForm = new CreateTeacherForm();

        createTeacherForm.setBranch(teacherEntity.getBranch());
        createTeacherForm.setName(teacherEntity.getName());
        createTeacherForm.setId(teacherEntity.getId());
        createTeacherForm.setPassword(teacherEntity.getPassword());
        createTeacherForm.setUserName(teacherEntity.getUserName());

        model.addAttribute("teacherList", teacherService.getAll().stream().map(TeacherEntity::toDTO).collect(Collectors.toList()));
        model.addAttribute("createTeacherForm",createTeacherForm);
        return "adminPanelTeacher";
    }
    @GetMapping
    private String getTeacherById( Model model){
        model.addAttribute("teachers",teacherService.getAll());
        return "teachers";
    }
}
