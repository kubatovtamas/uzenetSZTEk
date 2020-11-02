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
public class HomeController {

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



    /*          Queries          */

    private List<Post> getPosts() {

        return postServ.getPostRepo().findAll();
    }

    private List<Post> getPostsOrdered(Topic topic) {
        return postServ.getPostsOrdered(topic);
    }

    private List<Post> getPostsByUser(User user) {

        return postServ.getPostsByUser(user);
    }


    private List<Topic> getTopicsOrdered() {
        return topicServ.getTopicsOrdered();
    }

    private Topic getTopicByName(String name) {

        return topicServ.getTopicByName(name);
    }

    private List<User> getUsers() {

        return userServ.getUserRepo().findAll();
    }

    private User getUserByEmail(String email) {
        return userServ.getUserByEmail(email);
    }

    private Map<Topic, List<Post>> getTopicPostsOrdered() {
        Map<Topic, List<Post>> ordered = new HashMap<Topic, List<Post>>();
        List<Topic> topics = topicServ.getTopicsOrdered();
        for ( Topic t : topics) {
            List<Post> posts = postServ.getPostsOrdered(t);
            ordered.put(t, posts);
        }
       return ordered;
    }



    /*          Routing          */

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("topics", getTopicsOrdered());
        model.addAttribute("topicPosts", getTopicPostsOrdered());
//        model.addAttribute("users", getUsers());

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
        model.addAttribute("topics", getTopicsOrdered());
        model.addAttribute("topicPosts", getTopicPostsOrdered());

        return "topic";
    }

    @RequestMapping("/topics/{name}")
    public String searchForTopic(@PathVariable(value="name") String name, Model model) throws RecordNotFoundException {
        Topic topic = getTopicByName(name);

        model.addAttribute("specificTopic", topic);
        model.addAttribute("posts", getPostsOrdered(topic));

        return "topicdetails";
    }

    @RequestMapping("/user/{email}")
    public String searchForUser(@PathVariable(value="email") String email, Model model) throws RecordNotFoundException{
        User user = getUserByEmail(email);

        model.addAttribute("user", user);
        model.addAttribute("usersPosts", getPostsByUser(user));

        return "user";
    }


}


