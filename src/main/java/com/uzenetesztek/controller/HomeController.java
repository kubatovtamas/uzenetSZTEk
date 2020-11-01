package com.uzenetesztek.controller;

import com.uzenetesztek.Exceptions.RecordNotFoundException;
import com.uzenetesztek.domain.Post;
import com.uzenetesztek.domain.Topic;
import com.uzenetesztek.domain.User;
import com.uzenetesztek.service.PostService;
import com.uzenetesztek.service.TopicService;
import com.uzenetesztek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    PostService postServ;

    @Autowired
    UserService userServ;

    @Autowired
    TopicService topicServ;

    private List<Post> getPosts() {
        return postServ.getPostRepo().findAll();
    }

    private List<Topic> getTopics() {
        return topicServ.getTopicRepo().findAll();
    }

    private List<User> getUsers() {
        return userServ.getUserRepo().findAll();
    }



    /*          Routing          */

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
        model.addAttribute("posts", getPosts());
        model.addAttribute("topics", getTopics());
        model.addAttribute("users", getUsers());
        return "topic";
    }

    @RequestMapping("/topics/{name}")
    public String searchForTopic(@PathVariable(value="name") String name, Model model) throws RecordNotFoundException {
        model.addAttribute("specificTopic", topicServ.getSpecificTopic(name));
        return "topicdetails";
    }

    @RequestMapping("/user/{email}")
    public String searchForUser(@PathVariable(value="email") String email, Model model) throws RecordNotFoundException{
        model.addAttribute("user", userServ.getSpecificUser(email));
        return "user";
    }

}


