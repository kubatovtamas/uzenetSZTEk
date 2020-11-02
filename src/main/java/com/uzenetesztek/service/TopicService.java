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

    public Topic getTopicByName(String name) throws RecordNotFoundException {
        Topic topic = topicRepo.findFirstByName(name);

        if (topic == null) {
            throw new RecordNotFoundException("No topic found with name: " + name);
        } else {
            return topic;
        }
    }

    public List<Topic> getTopics() {

        return topicRepo.findAll();
    }
}
