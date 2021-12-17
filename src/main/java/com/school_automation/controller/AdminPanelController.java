package com.school_automation.controller;

import com.school_automation.entity.EmployeeEntity;
import com.school_automation.entity.StudentEntity;
import com.school_automation.entity.TeacherEntity;
import com.school_automation.form.CreateEmployeeForm;
import com.school_automation.form.CreateStudentForm;
import com.school_automation.form.CreateTeacherForm;
import com.school_automation.form.LoginForm;
import com.school_automation.service.EmployeeService;
import com.school_automation.service.StudentService;
import com.school_automation.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/admin")
public class AdminPanelController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService;

    @Autowired
    EmployeeService employeeService;


    @GetMapping
    private String getAdminLoginPage(Model model, HttpSession session){
        if (session.getAttribute("loginAdmin") != null){
            return "adminPanelTeacher";
        }
        model.addAttribute("loginForm",new LoginForm());
        return "adminLogin";
    }

    @PostMapping(value = "/login")
    private String adminLogin(@ModelAttribute LoginForm loginForm, HttpSession session, Model model){
        TeacherEntity teacherEntity = teacherService.getTeacherByUserName(loginForm.getUserName());
        if (teacherEntity != null && teacherEntity.getPassword().equals(loginForm.getPassword()) ){
            session.setAttribute("loginAdmin",loginForm.getUserName());
            model.addAttribute("teacherList", teacherService.getAll().stream().map(TeacherEntity::toDTO).collect(Collectors.toList()));
            model.addAttribute("createTeacherForm",new CreateTeacherForm());
            return "adminPanelTeacher";
        }
        return "redirect:/admin";
    }

    @GetMapping(value = "/get-admin-student")
    private String getAdminStudentPage(HttpSession session,Model model){
        if (session.getAttribute("loginAdmin") != null){
            model.addAttribute("studentList",studentService.getAll().stream().map(StudentEntity::toDTO).collect(Collectors.toList()));
            model.addAttribute("createStudentForm",new CreateStudentForm());
            return "adminPanelStudent";
        }
        return "redirect:/admin";
    }

    @GetMapping(value = "/get-admin-teacher")
    private String getAdminTeacherPage(HttpSession session,Model model){
        if (session.getAttribute("loginAdmin") != null){
            model.addAttribute("teacherList", teacherService.getAll().stream().map(TeacherEntity::toDTO).collect(Collectors.toList()));
            model.addAttribute("createTeacherForm",new CreateTeacherForm());
            return "adminPanelTeacher";
        }
        return "redirect:/admin";
    }

    @GetMapping(value = "/get-admin-employee")
    private String getAdminEmployeePage(HttpSession session,Model model){
        if (session.getAttribute("loginAdmin") != null){
            model.addAttribute("employeeList",employeeService.getAll().stream().map(EmployeeEntity::toDTO).collect(Collectors.toList()));
            model.addAttribute("createEmployeeForm",new CreateEmployeeForm());
            return "adminPanelEmployee";
        }
        return "redirect:/admin";
    }

    @GetMapping(value = "/logout")
    private String logOut(HttpSession session){
        session.setAttribute("loginAdmin",null);
        return "redirect:/admin";
    }
}
