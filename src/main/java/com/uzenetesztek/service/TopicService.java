package com.uzenetesztek.service;

import com.uzenetesztek.domain.Post;
import com.uzenetesztek.domain.Topic;
import com.uzenetesztek.domain.User;
import com.uzenetesztek.exceptions.RecordNotFoundException;
import com.uzenetesztek.repository.TopicRepository;
import com.uzenetesztek.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Service
public class TopicService {

    private TopicRepository topicRepo;
    @Autowired
    public void setTopicRepo(TopicRepository topicRepo) {
        this.topicRepo = topicRepo;
    }

    private UserRepository userRepo;
    @Autowired
    public void setUserRepo(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    private PostService postServ;
    @Autowired
    public void setPostService(PostService postServ) {
        this.postServ = postServ;
    }

    public Topic getTopicByName(String name) throws RecordNotFoundException {
        Topic topic = topicRepo.findFirstByName(name);

        if (topic == null) {
            throw new RecordNotFoundException("No topic found with name: " + name);
        } else {
            return topic;
        }
    }

    public List<Topic> getTopicsOrdered() {

        return topicRepo.findAllByOrderByNameAsc();
    }

    public List<Topic> getTopicsByUserOrdered(User user) {

        return topicRepo.findAllByUserOrderByTimestampAsc(user);
    }

    public Map<Topic, List<Post>> getAllTopicsAndTheirPostsOrdered() {
        Map<Topic, List<Post>> ordered = new HashMap<Topic, List<Post>>();
        List<Topic> topics = getTopicsOrdered();
        for (Topic topic : topics) {
            List<Post> posts = postServ.getPostsByTopicOrdered(topic);
            ordered.put(topic, posts);
        }
        return ordered;
    }

    public Map<Topic, List<Post>> getAllTopicsAndTheirPostsOrdered(User user) {
        Map<Topic, List<Post>> ordered = new HashMap<Topic, List<Post>>();
        List<Topic> topics = getTopicsByUserOrdered(user);
        for (Topic topic : topics) {
            List<Post> posts = postServ.getPostsByTopicOrdered(topic);
            ordered.put(topic, posts);
        }
        return ordered;
    }
}
