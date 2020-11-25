package com.uzenetesztek.controller;

import com.uzenetesztek.domain.User;
import com.uzenetesztek.exceptions.RecordNotFoundException;
import com.uzenetesztek.service.TopicWithPostsService;
import com.uzenetesztek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

//    @RequestMapping("/login")
//    public String login(Model model) {
//        return "login";
//    }

    @RequestMapping("/user/{id}")
    public String searchForUser(@PathVariable(value = "id") Long id, Model model) throws RecordNotFoundException {
        User user = userService.getById(id);

        model.addAttribute("user", user);
        model.addAttribute("topicsPosted", topicWithPostsService.getAllTopicsWithPostsOrdered(user));

        return "user";
    }
}
