package com.uzenetesztek.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthTestController {

    @GetMapping("/userlevel")
    public String userLevel() {
        return "<h1>User Level</h1>";
    }

    @GetMapping("/adminlevel")
    public String adminLevel() {
        return "<h1>Admin Level</h1>";
    }
}
