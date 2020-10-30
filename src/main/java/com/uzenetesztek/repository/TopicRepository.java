package com.uzenetesztek.repository;

import com.uzenetesztek.domain.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface TopicRepository extends CrudRepository<Topic, Long> {
    @Override
    ArrayList<Topic> findAll();
}
