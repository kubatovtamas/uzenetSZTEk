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
    public void setTopicWithPostsService(TopicWithPostsService topicWithPostsService) { this.topicWithPostsService = topicWithPostsService; }

    private UserServiceImpl userServiceImpl;
    @Autowired
    public void setUserService(UserServiceImpl userServ) {
        this.userServiceImpl = userServ;
    }



    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("topics", topicServiceImpl.getAllTopicsOrdered());
        model.addAttribute("topicsWithTop3Posts", topicWithPostsService.getAllTopicsWithTop3PostsOrdered());
        return "index";
    }

    @RequestMapping(path = {"/topics", "/topics/{id}"})
    public String getTopics(@PathVariable("id") Optional<Long> id, @AuthenticationPrincipal UserDetailsImpl user, Model model) throws RecordNotFoundException {
        // Specific Topic
        if (id.isPresent()) {
            Topic topic = topicServiceImpl.getById(id.get());
            model.addAttribute("specificTopic", topic);
            model.addAttribute("posts", postServiceImpl.getPostsByTopicOrdered(topic));

            model.addAttribute("newPost", new Post());
            model.addAttribute("userEmail", user.getUsername());
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
     * Saves A Post With Text Content Coming From HTML Form, Sets User, ParentTopic, TimeStamp automatically
     * @param topicId Current Topic's Id
     * @param user Currently Logged In User
     * @param post New Post Object
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
     * @param topicId Current Topic's Id
     * @param postId Specific Post's Id
     * @param post Existing Post Object
     * @return Redirect Back To Current Topic
     */
    @PostMapping("/topics/{topicId}/post/{postId}")
    public String editExistingPost(@PathVariable("topicId") Long topicId, @PathVariable("postId") Long postId, Post post) {
        Post originalPost = postServiceImpl.getById(postId);
        originalPost.setTextContent(post.getTextContent());
        postServiceImpl.createOrUpdate(originalPost);

        return "redirect:/topics/{topicId}";
    }

    /**
     * Delete Post With Specified Id
     * @param topicId Which Hold The Post
     * @param postId Which To Delete
     * @return Redirect To Containing Topic
     */
    @GetMapping("/topics/{topicId}/deletePost/{postId}")
    public String deletePost(@PathVariable("topicId") Long topicId, @PathVariable("postId") Long postId) {

        postServiceImpl.deleteById(postId);

        return "redirect:/topics/{topicId}";
    }
}


