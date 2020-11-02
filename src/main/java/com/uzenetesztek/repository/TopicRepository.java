package com.uzenetesztek.repository;

import com.uzenetesztek.domain.Post;
import com.uzenetesztek.domain.Topic;
import com.uzenetesztek.domain.User;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {
    List<Topic> findAllByOrderByNameAsc();

    Topic findFirstByName(String name);

    List<Topic> findAllByUserOrderByTimestampAsc(User user);
}
