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



    @GetMapping("/reg")
    public String register(Model model){
        model.addAttribute("user",new User());
        return "auth/reg";
    }

    @PostMapping("/reg")
    public String reg(@ModelAttribute User user, Model model){
        String result = userDetailsService.registerUser(user);
        if(result.equals("ok")){
            model.addAttribute("resultMessage","Thank you.\nWe have sent you email to "+user.getEmail()+".\nPlease click the link in that message to activate your account.");
        }else{
            model.addAttribute("resultMessage","Something went wrong. User registration failed.");
        }
        return "auth/login";
    }

    @RequestMapping(path = "/activation/{code}", method = RequestMethod.GET)
    public String activation(@PathVariable("code") String code, HttpServletResponse response){
        String result = userDetailsService.userActivation(code);
        if(result.equals("ok")){
            return "redirect:/login";
        }else{
            return "redirect:/login?error";
        }
    }



}


