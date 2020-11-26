package com.uzenetesztek.controller;

import com.uzenetesztek.domain.User;
import com.uzenetesztek.service.UserDetailsServiceImpl;
import com.uzenetesztek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
public class AuthController {

    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public void setUserDetailsService(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/login")
    public String login(){
        return "auth/login";
    }

    @GetMapping("/activation/login")
    public String loginFromActivation(){
        return "auth/login";
    }

    @GetMapping("/reg")
    public String register(Model model){
        model.addAttribute("user",new User());
        return "auth/reg";
    }

    @PostMapping("/reg")
    public String reg(@ModelAttribute User user){
        userDetailsService.registerUser(user);
        return "auth/login";
    }

    @RequestMapping(path = "/activation/{code}", method = RequestMethod.GET)
    public String activation(@PathVariable("code") String code, HttpServletResponse response){
        userDetailsService.userActivation(code);
        return "redirect:/login";
    }



}


