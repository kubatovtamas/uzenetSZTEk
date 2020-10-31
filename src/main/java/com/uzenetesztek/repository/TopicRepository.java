package com.uzenetesztek.repository;

import com.uzenetesztek.domain.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Long> {
    @Override
    List<Topic> findAll();
}
