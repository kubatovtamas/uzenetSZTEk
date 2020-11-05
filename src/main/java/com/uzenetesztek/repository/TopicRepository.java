package com.uzenetesztek.repository;

import com.uzenetesztek.domain.Topic;
import com.uzenetesztek.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {
    List<Topic> findAllByOrderByNameAsc();

    Topic findFirstByName(String name);

    List<Topic> findAllByUser(User user);

    List<Topic> findAllByUserOrderByTimestampAsc(User user);
}
