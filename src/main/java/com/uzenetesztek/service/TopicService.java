package com.uzenetesztek.service;

import com.uzenetesztek.repository.TopicRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class TopicService {
    @Autowired
    TopicRepository topicRepo;
}
