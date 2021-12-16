package com.school_automation.controller;

import com.school_automation.entity.TeacherEntity;
import com.school_automation.form.LoginForm;
import com.school_automation.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/")
public class LoginPageController
{


    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping
    public String getLoginPage( Model model) {
        model.addAttribute("loginForm",new LoginForm());
        return "login";
    }


    @PostMapping(value = "/login")
    public String login(@ModelAttribute LoginForm loginForm, HttpSession session,Model model){

        TeacherEntity teacherEntity = teacherRepository.findTeacherEntityByUserName(loginForm.getUserName());

        return "homePage";
    }
}
