package com.syrym.bootvue.bootvue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController{

    @RequestMapping("/home")
    public String home(){return "index.html";}

    @RequestMapping("/register")
    public String register(){return "register.html";}

}

