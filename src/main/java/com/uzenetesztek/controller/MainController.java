package com.uzenetesztek.controller;

import com.uzenetesztek.domain.Post;
import com.uzenetesztek.domain.Topic;
import com.uzenetesztek.domain.User;
import com.uzenetesztek.exceptions.RecordNotFoundException;
import com.uzenetesztek.service.PostService;
import com.uzenetesztek.service.TopicService;
import com.uzenetesztek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    private PostService postServ;

    @Autowired
    public void setPostService(PostService postServ) {
        this.postServ = postServ;
    }

    private UserService userServ;

    @Autowired
    public void setUserService(UserService userServ) {
        this.userServ = userServ;
    }

    private TopicService topicServ;
    @Autowired
    public void setTopicService(TopicService topicServ) {
        this.topicServ = topicServ;
    }



    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("topics", topicServ.getTopicsOrdered());
        model.addAttribute("topicPosts", topicServ.getAllTopicsWithPostsOrdered());

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
        model.addAttribute("topics", topicServ.getTopicsOrdered());
        model.addAttribute("topicPosts", topicServ.getAllTopicsWithPostsOrdered());

        return "topic";
    }

    @RequestMapping("/topics/{name}")
    public String searchForTopic(@PathVariable(value = "name") String name, Model model) throws RecordNotFoundException {
        Topic topic = topicServ.getTopicByName(name);

        model.addAttribute("specificTopic", topic);
        model.addAttribute("posts", postServ.getPostsOrdered(topic));

        return "topic_details";
    }

    @RequestMapping("/user/{email}")
    public String searchForUser(@PathVariable(value = "email") String email, Model model) throws RecordNotFoundException {
        User user = userServ.getUserByEmail(email);

        model.addAttribute("user", user);
        model.addAttribute("topics", topicServ.getTopicsByUserOrdered(user));
        model.addAttribute("topicsPosted", topicServ.getAllTopicsWithPostsOrdered(user));

        return "user";
    }


}


