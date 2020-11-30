package com.uzenetesztek.repository;

import com.uzenetesztek.domain.Topic;
import com.uzenetesztek.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {
    List<Topic> findAllByOrderByNameAsc();

    Optional<Topic> findFirstByName(String name);

    List<Topic> findAllByUserOrderByNameAsc(User user);
}
