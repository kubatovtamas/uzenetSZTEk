package com.uzenetesztek.controller;

import com.uzenetesztek.domain.Topic;
import com.uzenetesztek.exceptions.RecordNotFoundException;
import com.uzenetesztek.service.PostServiceImpl;
import com.uzenetesztek.service.TopicServiceImpl;
import com.uzenetesztek.service.TopicWithPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class TopicController {

    private PostServiceImpl postServiceImpl;
    @Autowired
    public void setPostService(PostServiceImpl postServ) {
        this.postServiceImpl = postServ;
    }

    private TopicServiceImpl topicServiceImpl;
    @Autowired
    public void setTopicService(TopicServiceImpl topicServ) {
        this.topicServiceImpl = topicServ;
    }

    private TopicWithPostsService topicWithPostsService;
    @Autowired
    public void setTopicWithPostsService(TopicWithPostsService topicWithPostsService) { this.topicWithPostsService = topicWithPostsService; }



    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("topics", topicServiceImpl.getAllTopicsOrdered());
        model.addAttribute("topicsWithPosts", topicWithPostsService.getAllTopicsWithPostsOrdered());
        return "index";
    }

    @RequestMapping(path = {"/topics", "/topics/{id}"})
    public String getTopics(@PathVariable("id") Optional<Long> id, Model model) throws RecordNotFoundException {
        // Specific Topic
        if (id.isPresent()) {
            Topic topic = topicServiceImpl.getById(id.get());
            model.addAttribute("specificTopic", topic);
            model.addAttribute("posts", postServiceImpl.getPostsByTopicOrdered(topic));

            return "topic_details";
        }
        // Every Topic
        else {
            model.addAttribute("topicsWithPosts", topicWithPostsService.getAllTopicsWithPostsOrdered());

            return "topics";
        }
    }


}


