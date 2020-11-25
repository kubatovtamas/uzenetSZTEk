package com.uzenetesztek.controller;

import com.uzenetesztek.domain.Topic;
import com.uzenetesztek.exceptions.RecordNotFoundException;
import com.uzenetesztek.service.PostService;
import com.uzenetesztek.service.TopicService;
import com.uzenetesztek.service.TopicWithPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class TopicController {

    private PostService postService;
    @Autowired
    public void setPostService(PostService postServ) {
        this.postService = postServ;
    }

    private TopicService topicService;
    @Autowired
    public void setTopicService(TopicService topicServ) {
        this.topicService = topicServ;
    }

    private TopicWithPostsService topicWithPostsService;
    @Autowired
    public void setTopicWithPostsService(TopicWithPostsService topicWithPostsService) { this.topicWithPostsService = topicWithPostsService; }



    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("topicsWithPosts", topicWithPostsService.getAllTopicsWithPostsOrdered());
        return "index";
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


}


