package com.uzenetesztek.controller;

import com.uzenetesztek.domain.Post;
import com.uzenetesztek.domain.Topic;
import com.uzenetesztek.domain.User;
import com.uzenetesztek.domain.testPOJO;
import com.uzenetesztek.repository.TopicRepository;
import com.uzenetesztek.repository.UserRepository;
import com.uzenetesztek.repository.testPOJORepository;
import com.uzenetesztek.repository.PostRepository;
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
        model.addAttribute("posts", getPosts());
        model.addAttribute("topics", getTopics());
        model.addAttribute("users", getUsers());
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
    PostRepository postRepo;

    @Autowired
    TopicRepository topicRepo;

    @Autowired
    UserRepository userRepo;

    
    private ArrayList<Post> getPosts() {
        return postRepo.findAll();
    }

    private ArrayList<Topic> getTopics() {
        return topicRepo.findAll();
    }

    private ArrayList<User> getUsers() {
        return userRepo.findAll();
    }
}


