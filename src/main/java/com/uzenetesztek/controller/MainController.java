package com.uzenetesztek.controller;

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

import java.util.Optional;

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
        model.addAttribute("topicPosts", topicServ.getAllTopicsAndTheirPostsOrdered());

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

    @RequestMapping(path = {"/topics", "/topics/{name}"})
    public String searchForTopic(@PathVariable("name") Optional<String> name, Model model) throws RecordNotFoundException {
        if (name.isPresent()) {
            // Every Topic

            Topic topic = topicServ.getTopicByName(name.get());

            model.addAttribute("specificTopic", topicServ.getTopicByName(name.get()));
            model.addAttribute("posts", postServ.getPostsByTopicOrdered(topic));

            return "topic_details";
        } else {
            // Specific Topic

            model.addAttribute("topics", topicServ.getTopicsOrdered());
            model.addAttribute("topicPosts", topicServ.getAllTopicsAndTheirPostsOrdered());

            return "topics";
        }
    }

    @RequestMapping("/user/{email}")
    public String searchForUser(@PathVariable(value = "email") String email, Model model) throws RecordNotFoundException {
        User user = userServ.getUserByEmail(email);

        model.addAttribute("user", user);
        model.addAttribute("topics", topicServ.getTopicsByUserOrdered(user));
        model.addAttribute("topicsPosted", topicServ.getAllTopicsAndTheirPostsOrdered(user));

        return "user";
    }


}


