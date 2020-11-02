package com.uzenetesztek.service;

import com.uzenetesztek.exceptions.RecordNotFoundException;
import com.uzenetesztek.domain.Topic;
import com.uzenetesztek.repository.TopicRepository;
import com.uzenetesztek.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class TopicService {
    private TopicRepository topicRepo;
    private UserRepository userRepo;

    @Autowired
    public void setTopicRepo(TopicRepository topicRepo) {
        this.topicRepo = topicRepo;
    }

    @Autowired
    public void setUserRepo(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public Topic getSpecificTopic(String name) throws RecordNotFoundException {
        Topic t = topicRepo.findFirstByName(name);

        if (t == null) {
            throw new RecordNotFoundException("No topic found with name: " + name);
        } else {
            return topicRepo.findFirstByName(name);
        }
    }

    public List<Topic> getTopics() {
        return topicRepo.findAll();
    }


    // basic idea of how internally created topic function might work
//    @PostConstruct // this right now is always called, how do I prevent that?
//    public void init() {
//        User user = new User( "ijustwantto@register", "thisismypassword", false);
//        userRepo.save(user);
//        Topic topic = new Topic("This is my topic", new Date(), user);
//        topicRepo.save(topic);
//    }
}
