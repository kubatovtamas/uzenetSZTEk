package com.uzenetesztek.controller;

import com.uzenetesztek.domain.testPOJO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("testAttribute", "This is a test attribute");
        model.addAttribute("testPOJOs", getTestPOJOs()); // inject a list of pojos into html
        return "index";
    }

    private ArrayList<testPOJO> getTestPOJOs() {
        ArrayList<testPOJO> pojos = new ArrayList<>();
        testPOJO pojo1 = new testPOJO(1, "macska", "macs@ka.com", new Date(), true);
        testPOJO pojo2 = new testPOJO(1, "kutya", "ku@tya.com", new Date(),false);

        pojos.add(pojo1);
        pojos.add(pojo2);
        return pojos;
    }
}


