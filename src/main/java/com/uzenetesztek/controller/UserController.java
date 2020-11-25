package com.uzenetesztek.controller;

import com.uzenetesztek.domain.User;
import com.uzenetesztek.exceptions.RecordNotFoundException;
import com.uzenetesztek.service.TopicWithPostsService;
import com.uzenetesztek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserService userService;
    @Autowired
    public void setUserService(UserService userServ) {
        this.userService = userServ;
    }
    
    private TopicWithPostsService topicWithPostsService;
    @Autowired
    public void setTopicWithPostsService(TopicWithPostsService topicWithPostsService) { this.topicWithPostsService = topicWithPostsService; }

    @RequestMapping("/profile")
    public String profile(Model model) {
        return "profile";
    }

    @RequestMapping("/user/{id}")
    public String searchForUser(@PathVariable(value = "id") Long id, Model model) throws RecordNotFoundException {
        User user = userService.getById(id);

        model.addAttribute("user", user);
        model.addAttribute("topicsPosted", topicWithPostsService.getAllTopicsWithPostsOrdered(user));

        return "user";
    }


    // TODO: reg and login is on the same page -> add new User model to login ???

//    @RequestMapping("/login")
//    public String login(Model model) {
//        model.addAttribute("user", new User());
//        return "login";
//
//    }

//    @RequestMapping("/registration")
//    public String login(Model model) {
//        model.addAttribute("user", new User());
//        return "auth/login";
//    }

    @PostMapping(value = "/reg")
    public String greetingSubmit(@ModelAttribute User user) {
        return "auth/login";
    }
}
