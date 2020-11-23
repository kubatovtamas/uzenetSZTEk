package com.uzenetesztek.controller;

import com.uzenetesztek.domain.Topic;
import com.uzenetesztek.domain.User;
import com.uzenetesztek.exceptions.RecordNotFoundException;
import com.uzenetesztek.service.PostServiceImpl;
import com.uzenetesztek.service.TopicServiceImpl;
import com.uzenetesztek.service.TopicWithPostsService;
import com.uzenetesztek.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class MainController {

    private PostServiceImpl postService;
    @Autowired
    public void setPostService(PostServiceImpl postServ) {
        this.postService = postServ;
    }

    private UserServiceImpl userService;
    @Autowired
    public void setUserService(UserServiceImpl userServ) {
        this.userService = userServ;
    }

    private TopicServiceImpl topicService;
    @Autowired
    public void setTopicService(TopicServiceImpl topicServ) {
        this.topicService = topicServ;
    }

    private TopicWithPostsService topicWithPostsService;
    @Autowired
    public void setTopicWithPostsService(TopicWithPostsService topicWithPostsService) { this.topicWithPostsService = topicWithPostsService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("topicsWithPosts", topicWithPostsService.getAllTopicsWithPostsOrdered());

        return "index";
    }

    @RequestMapping("/profile")
    public String profile(Model model) {

        return "profile";
    }

    @RequestMapping("/signin")
    public String signin(Model model) {

        return "sign_in";
    }

    @RequestMapping(path = {"/topics", "/topics/{id}"})
    public String getTopics(@PathVariable("id") Optional<Long> id, Model model) throws RecordNotFoundException {
        // Specific Topic
        if (id.isPresent()) {

            Topic topic = topicService.getById(id.get());
            model.addAttribute("specificTopic", topic);
            model.addAttribute("posts", postService.getPostsByTopicOrdered(topic));

            return "topic_details";

        }
        // Every Topic
        else {

            model.addAttribute("topicsWithPosts", topicWithPostsService.getAllTopicsWithPostsOrdered());

            return "topics";
        }
    }

    @RequestMapping("/user/{id}")
    public String searchForUser(@PathVariable(value = "id") Long id, Model model) throws RecordNotFoundException {
        User user = userService.getById(id);

        model.addAttribute("user", user);
        model.addAttribute("topics", topicService.getAllTopicsOrdered(user));
        model.addAttribute("topicsPosted", topicWithPostsService.getAllTopicsWithPostsOrdered(user));

        return "user";
    }
}


