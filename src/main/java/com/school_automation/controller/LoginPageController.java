package com.school_automation.controller;

import com.school_automation.entity.StudentEntity;
import com.school_automation.form.LoginForm;
import com.school_automation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/")
public class LoginPageController
{


    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public String getLoginPage(Model model,HttpSession session) {
        if (session.getAttribute("loginUser") != null){
            return "teachers";
        }
        model.addAttribute("loginForm",new LoginForm());
        return "login";
    }


    @PostMapping(value = "/login")
    public String login(@ModelAttribute LoginForm loginForm, HttpSession session, Model model, HttpServletResponse response, HttpServletRequest request){


        StudentEntity studentEntity = studentRepository.findStudentEntityByUserName(loginForm.getUserName());
        if (studentEntity != null && studentEntity.getPassword().equals(loginForm.getPassword()) ){
            Cookie cookie = new Cookie( "userName", loginForm.getUserName());
            cookie.setMaxAge(60*60*24);
            response.addCookie(cookie);
            Cookie cookie1 = new Cookie("password", loginForm.getPassword());
            cookie1.setMaxAge(60*60*24);
            response.addCookie(cookie1);
            session.setAttribute("loginUser",loginForm.getUserName());
            Cookie[] cookies = request.getCookies();
            return "homePage";
        }
        return "redirect:/";
    }
}
