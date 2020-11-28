package com.uzenetesztek.controller;

import com.uzenetesztek.domain.Post;
import com.uzenetesztek.domain.Topic;
import com.uzenetesztek.domain.User;
import com.uzenetesztek.domain.UserDetailsImpl;
import com.uzenetesztek.exceptions.RecordNotFoundException;
import com.uzenetesztek.service.PostServiceImpl;
import com.uzenetesztek.service.TopicServiceImpl;
import com.uzenetesztek.service.TopicWithPostsService;
import com.uzenetesztek.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.Date;

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
    public void setTopicWithPostsService(TopicWithPostsService topicWithPostsService) {
        this.topicWithPostsService = topicWithPostsService;
    }

    private UserServiceImpl userServiceImpl;

    @Autowired
    public void setUserService(UserServiceImpl userServ) {
        this.userServiceImpl = userServ;
    }


    @RequestMapping("/")
    public String index(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        /* Check if user has already liked the post*/
        User user = userServiceImpl.getByEmail(userDetails.getUsername());
        model.addAttribute("user", user);

        model.addAttribute("topics", topicServiceImpl.getAllTopicsOrdered());
        model.addAttribute("topicsWithTop3Posts", topicWithPostsService.getAllTopicsWithTop3PostsOrdered());
        /* For New Topic Creation */
        model.addAttribute("newTopic", new Topic());
        model.addAttribute("userEmail", userDetails.getUsername());
        return "index";
    }

    @RequestMapping(path = {"/topics", "/topics/{id}"})
    public String getTopics(@PathVariable("id") Optional<Long> id, @AuthenticationPrincipal UserDetailsImpl userDetails, Model model) throws RecordNotFoundException {
        //check if user has already liked the post
        User user = userServiceImpl.getByEmail(userDetails.getUsername());
        model.addAttribute("user", user);


        // Specific Topic
        if (id.isPresent()) {
            Topic topic = topicServiceImpl.getById(id.get());
            model.addAttribute("specificTopic", topic);
            model.addAttribute("posts", postServiceImpl.getPostsByTopicOrdered(topic));

            /* For New Post Creation */
            model.addAttribute("newPost", new Post());
            model.addAttribute("userEmail", userDetails.getUsername());
            model.addAttribute("editedPost", new Post());
            return "topic_details";
        }
        // Every Topic
        else {
            model.addAttribute("topics", topicServiceImpl.getAllTopicsOrdered());
            model.addAttribute("topicsWithTop3Posts", topicWithPostsService.getAllTopicsWithTop3PostsOrdered());
            return "topics";
        }
    }

    /**
     * Saves A Post With Text Content Coming From HTML Form, Sets User, ParentTopic, TimeStamp Automatically
     *
     * @param topicId Current Topic's Id
     * @param user    Currently Logged In User
     * @param post    New Post Object
     * @return Redirect Back To Current Topic
     */
    @PostMapping("/topics/{topicId}/post")
    public String createNewPost(@PathVariable("topicId") Long topicId, @AuthenticationPrincipal UserDetailsImpl user, Post post) {

        post.setUser(userServiceImpl.getByEmail(user.getUsername()));
        post.setParentTopic(topicServiceImpl.getById(topicId));
        post.setTimestamp(new Date());
        postServiceImpl.createOrUpdate(post);

        return "redirect:/topics/{topicId}";
    }

    /**
     * Saves A Post With Text Coming From HTML Form
     *
     * @param topicId Current Topic's Id
     * @param postId  Specific Post's Id
     * @param post    Existing Post Object
     * @return Redirect Back To Current Topic
     */
    @PostMapping("/topics/{topicId}/post/{postId}")
    public String editExistingPost(@PathVariable("topicId") Long topicId, @PathVariable("postId") Long postId, Post post) {
        Post originalPost = postServiceImpl.getById(postId);

        originalPost.setTextContent(post.getTextContent());
        originalPost.setTimestamp(new Date());

        postServiceImpl.createOrUpdate(originalPost);

        return "redirect:/topics/{topicId}";
    }

    /**
     * Delete Post With Specified Id
     *
     * @param topicId Which Hold The Post
     * @param postId  Which To Delete
     * @return Redirect To Containing Topic
     */
    @GetMapping("/topics/{topicId}/deletePost/{postId}")
    public String deletePost(@PathVariable("topicId") Long topicId, @PathVariable("postId") Long postId) {

        postServiceImpl.deleteById(postId);

        return "redirect:/topics/{topicId}";
    }


    /**
     * Saves A Topic With Text Content Coming From HTML Form, Sets User, TimeStamp Automatically
     *
     * @param user  Currently Logged In User
     * @param topic New Topic Object
     * @return Redirect To Created Topic
     */
    @PostMapping("/createTopic")
    public String createNewTopic(@AuthenticationPrincipal UserDetailsImpl user, Topic topic) {
        topic.setUser(userServiceImpl.getByEmail(user.getUsername()));
        topic.setTimestamp(new Date());

        topicServiceImpl.createOrUpdate(topic);

        var newTopicId = topic.getId();
        return "redirect:/topics/" + newTopicId;
    }

    /**
     * Like function from index/topics pages
     *
     * @param pageName    Current Page
     * @param userDetails Currently Logged In User
     * @param postId      Post Which Liked By User
     * @return Redirect To Current Page
     */
    @PostMapping("/{page}/{postId}/like")
    public String likePost(@PathVariable("page") String pageName, @PathVariable("postId") Long postId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Post post = postServiceImpl.getById(postId);
        User user = userServiceImpl.getByEmail(userDetails.getUsername());
        post.getUserLikes().add(user);
        postServiceImpl.createOrUpdate(post);
        switch (pageName) {
            case "index":
                return "redirect:/";
            case "topics":
                return "redirect:/topics";
        }
        return "redirect:/topics";
    }

    /**
     * Like Function From the Topic Details page
     *
     * @param userDetails Currently Logged In User
     * @param postId      Post Which Liked By User
     * @param topicId     The Current Topic
     * @return Redirect Back To Current Topic
     */
    @PostMapping("/topicDetails/{postId}/{topicId}/like")
    public String likePostInTopicsDetails(@PathVariable("postId") Long postId, @PathVariable("topicId") Long topicId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Post post = postServiceImpl.getById(postId);
        User user = userServiceImpl.getByEmail(userDetails.getUsername());
        post.getUserLikes().add(user);
        postServiceImpl.createOrUpdate(post);
        return "redirect:/topics/{topicId}";
    }


    /**
     * Follow function
     *
     * @param pageName    Current Page (topics, topicDetails)
     * @param userDetails Currently Logged In User
     * @param topicId     Topic Followed By User
     * @return Redirect To Current Page
     */
    @PostMapping("/{page}/{topicId}/follow")
    public String followTopic(@PathVariable("page") String pageName, @PathVariable("topicId") Long topicId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Topic topic = topicServiceImpl.getById(topicId);
        User user = userServiceImpl.getByEmail(userDetails.getUsername());
        topic.getFollowers().add(user);
        topicServiceImpl.createOrUpdate(topic);
        switch (pageName) {
            case "topics":
                return "redirect:/topics";
            case "topicDetails":
                return "redirect:/topics/{topicId}";
        }
        return "redirect:/topics";

    }
    /**
     * Unfollow function
     *
     * @param userDetails Currently Logged In User
     * @param topicId     Topic Followed By User
     * @return Redirect To Profile page
     */
    @PostMapping("/profile/unfollow/{topicId}")
    public String unfollowTopic(@PathVariable("topicId") Long topicId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        Topic topic = topicServiceImpl.getById(topicId);
        User user = userServiceImpl.getByEmail(userDetails.getUsername());
        topic.getFollowers().remove(user);
        topicServiceImpl.createOrUpdate(topic);
        return "redirect:/profile";
    }
}


