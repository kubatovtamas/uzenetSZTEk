package com.uzenetesztek.controller;

import com.uzenetesztek.domain.User;
import com.uzenetesztek.exceptions.RecordNotFoundException;
import com.uzenetesztek.service.TopicServiceImpl;
import com.uzenetesztek.service.TopicWithPostsService;
import com.uzenetesztek.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserServiceImpl userServiceImpl;
    @Autowired
    public void setUserService(UserServiceImpl userServ) {
        this.userServiceImpl = userServ;
    }
    
    private TopicWithPostsService topicWithPostsService;
    @Autowired
    public void setTopicWithPostsService(TopicWithPostsService topicWithPostsService) { this.topicWithPostsService = topicWithPostsService; }

    private TopicServiceImpl topicServiceImpl;
    @Autowired
    public void setTopicService(TopicServiceImpl topicServ) {
        this.topicServiceImpl = topicServ;
    }



    @RequestMapping("/profile")
    public String profile(Model model) {
        return "profile";
    }

    @RequestMapping("/user/{id}")
    public String searchForUser(@PathVariable(value = "id") Long id, Model model) throws RecordNotFoundException {
        User user = userServiceImpl.getById(id);

        model.addAttribute("user", user);
        model.addAttribute("topicsOfUser", topicServiceImpl.getAllTopicsOrdered(user));
        model.addAttribute("topicsWithTop3PostsOfUser", topicWithPostsService.getAllTopicsWithTop3PostsOrdered(user));

        return "user";
    }
}
