package com.uzenetesztek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login(){
        return "auth/login";
    }

    @GetMapping("/reg")
    public String register(){
        return "auth/reg";
    }


}


