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

    private PostServiceImpl postServImpl;
    @Autowired
    public void setPostServiceImpl(PostServiceImpl postServ) {
        this.postServImpl = postServ;
    }

    private TopicServiceImpl topicServImpl;
    @Autowired
    public void setTopicServiceImpl(TopicServiceImpl topicServ) {
        this.topicServImpl = topicServ;
    }


    /**
     * Order By: Topic.name ASC => Post.timestamp DESC
     * @return Every Topic With All Corresponding Posts
     */
    public Map<Topic, List<Post>> getAllTopicsWithPostsOrdered() {
        Map<Topic, List<Post>> orderedTopicsWithPosts = new HashMap<Topic, List<Post>>();
        List<Topic> topics = topicServImpl.getAllTopicsOrdered();

        for (Topic topic : topics) {
            List<Post> posts = postServImpl.getPostsByTopicOrdered(topic);
            orderedTopicsWithPosts.put(topic, posts);
        }

        return orderedTopicsWithPosts;
    }

    /**
     * Limit Posts: 3
     * Order By: Topic.name ASC => Post.timestamp DESC
     * Limit Number Of Posts To 3
     * @return Every Topic 3 Corresponding Posts
     */
    public Map<Topic, List<Post>> getAllTopicsWithTop3PostsOrdered() {
        Map<Topic, List<Post>> orderedTopicsWithPosts = new HashMap<Topic, List<Post>>();
        List<Topic> topics = topicServImpl.getAllTopicsOrdered();

        for (Topic topic : topics) {
            List<Post> posts = postServImpl.getTop3PostsByTopicOrdered(topic);
            orderedTopicsWithPosts.put(topic, posts);
        }

        return orderedTopicsWithPosts;
    }

    /**
     * Order By: Topic.name ASC => Post.timestamp DESC
     * @param user Whose Topics To Query
     * @return One User's Topics With Corresponding Posts
     */
    public Map<Topic, List<Post>> getAllTopicsWithPostsOrdered(User user) {
        Map<Topic, List<Post>> orderedTopicsWithPosts = new HashMap<Topic, List<Post>>();
        List<Topic> topics = topicServImpl.getAllTopicsOrdered(user);

        for (Topic topic : topics) {
            List<Post> posts = postServImpl.getPostsByTopicOrdered(topic);
            orderedTopicsWithPosts.put(topic, posts);
        }

        return orderedTopicsWithPosts;
    }

    /**
     * Limit Posts: 3
     * Order By: Topic.name ASC => Post.timestamp DESC
     * @param user Whose Topics To Query
     * @return One User's Topics With Corresponding Posts
     */
    public Map<Topic, List<Post>> getAllTopicsWithTop3PostsOrdered(User user) {
        Map<Topic, List<Post>> orderedTopicsWithPosts = new HashMap<Topic, List<Post>>();
        List<Topic> topics = topicServImpl.getAllTopicsOrdered(user);

        for (Topic topic : topics) {
            List<Post> posts = postServImpl.getTop3PostsByTopicOrdered(topic);
            orderedTopicsWithPosts.put(topic, posts);
        }

        return orderedTopicsWithPosts;
    }
}
