package com.school_automation.controller;

import com.school_automation.entity.StudentEntity;
import com.school_automation.entity.TeacherEntity;
import com.school_automation.form.CreateStudentForm;
import com.school_automation.form.CreateTeacherForm;
import com.school_automation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/student")
public class StudentController
{
    @Autowired
    private StudentService studentService;


    @PostMapping(value = "/create")
    private String crateOrUpdateStudent(@ModelAttribute CreateStudentForm createStudentForm){
        studentService.createStudent(createStudentForm);
        return "redirect:/admin/get-admin-student";
    }

    @GetMapping(value = "/delete/{studentId}")
    private String deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
        return "redirect:/admin/get-admin-student";
    }

    @GetMapping(value = "/{studentId}")
    private String getStudentById(@PathVariable("studentId") Long studentId, Model model){

        StudentEntity studentEntity = studentService.getStudentById(studentId);

        CreateStudentForm createStudentForm = new CreateStudentForm();

        createStudentForm.setName(studentEntity.getName());
        createStudentForm.setId(studentEntity.getId());
        createStudentForm.setPassword(studentEntity.getPassword());
        createStudentForm.setUserName(studentEntity.getUserName());
        createStudentForm.setYourClass(studentEntity.getYourClass());

        model.addAttribute("studentList", studentService.getAll().stream().map(StudentEntity::toDTO).collect(Collectors.toList()));
        model.addAttribute("createStudentForm",createStudentForm);
        return "adminPanelStudent";
    }

    @GetMapping
    private String getStudentById( Model model){
        model.addAttribute("students",studentService.getAll());
        return "students";
    }

}
