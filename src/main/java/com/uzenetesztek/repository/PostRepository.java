package com.uzenetesztek.repository;

import com.uzenetesztek.domain.Post;
import com.uzenetesztek.domain.Topic;
import com.uzenetesztek.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    @Override
    List<Post> findAll();

    List<Post> findAllByUser(User u);

    List<Post> findAllByParentTopicOrderByTimestampAsc(Topic topic);

}
