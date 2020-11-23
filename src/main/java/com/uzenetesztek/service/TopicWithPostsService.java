package com.uzenetesztek.service;

import com.uzenetesztek.domain.Post;
import com.uzenetesztek.domain.Topic;
import com.uzenetesztek.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TopicWithPostsService {

    private PostService postServ;
    @Autowired
    public void setPostService(PostService postServ) {
        this.postServ = postServ;
    }

    private TopicService topicServ;
    @Autowired
    public void setTopicService(TopicService topicServ) {
        this.topicServ = topicServ;
    }



    public Map<Topic, List<Post>> getAllTopicsWithPostsOrdered() {
        Map<Topic, List<Post>> orderedTopicsWithPosts = new HashMap<Topic, List<Post>>();
        List<Topic> topics = topicServ.getAllTopicsOrdered();
        for (Topic topic : topics) {
            List<Post> posts = postServ.getPostsByTopicOrdered(topic);
            orderedTopicsWithPosts.put(topic, posts);
        }
        return orderedTopicsWithPosts;
    }

    public Map<Topic, List<Post>> getAllTopicsWithPostsOrdered(User user) {
        Map<Topic, List<Post>> ordered = new HashMap<Topic, List<Post>>();
        List<Topic> topics = topicServ.getAllTopicsOrdered(user);
        for (Topic topic : topics) {
            List<Post> posts = postServ.getPostsByTopicOrdered(topic);
            ordered.put(topic, posts);
        }
        return ordered;
    }
}
