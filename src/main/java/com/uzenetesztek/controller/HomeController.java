package com.uzenetesztek.controller;

import com.uzenetesztek.domain.testPOJO;
import com.uzenetesztek.repository.testPOJORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.ArrayList;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("testAttribute", "This is a test attribute");
        model.addAttribute("testPOJOs", getTestPOJOs());
        return "index";
    }

    @RequestMapping("/profile")
    public String profile(Model model) {
        return "profile";
    }

    @RequestMapping("/sign")
    public String sign(Model model) {
        return "sign";
    }

    @RequestMapping("/topic")
    public String topic(Model model) {
        return "topic";
    }

    @RequestMapping("/topicdetails")
    public String searchForTopic(Model model) {
        return "topicdetails";
    }


    @Autowired
    testPOJORepository pojoRepo;

    private ArrayList<testPOJO> getTestPOJOs() {
        ArrayList<testPOJO> pojos = pojoRepo.findAll();
        return pojos;
    }
}


