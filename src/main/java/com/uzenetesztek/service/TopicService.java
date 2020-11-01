package com.uzenetesztek.service;

import com.uzenetesztek.Exceptions.RecordNotFoundException;
import com.uzenetesztek.domain.Topic;
import com.uzenetesztek.repository.TopicRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class TopicService {
    @Autowired
    TopicRepository topicRepo;

    public Topic getSpecificTopic(String name) throws RecordNotFoundException {
        Topic t = topicRepo.findFirstByName(name);

        if (t == null) {
            throw new RecordNotFoundException("No topic found with name: " + name);
        } else {
            return topicRepo.findFirstByName(name);
        }
    }
}
