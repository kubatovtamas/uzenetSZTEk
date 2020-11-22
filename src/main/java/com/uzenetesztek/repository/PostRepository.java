package com.uzenetesztek.repository;

import com.uzenetesztek.domain.Post;
import com.uzenetesztek.domain.Topic;
import com.uzenetesztek.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findAllByParentTopicOrderByTimestampDesc(Topic topic);

    List<Post> findAllByUserOrderByTimestampDesc(User user);
}
