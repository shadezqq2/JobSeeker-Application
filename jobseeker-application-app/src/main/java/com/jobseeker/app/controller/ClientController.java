package com.jobseeker.app.controller;

import com.jobseeker.app.service.JobSeekerFacade;
import com.jobseeker.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    JobSeekerFacade jobSeekerFacade;

    @GetMapping
    public String registerPage(Model model) {
        model.addAttribute("user", new UserEntity());
        return "client";
    }

    @PostMapping
    public String successfulRegistration(UserEntity user) {
        if (jobSeekerFacade.registerUser(user)) {
            return "redirect:search";
        } else {
            return "redirect:client";
        }

    }
}
