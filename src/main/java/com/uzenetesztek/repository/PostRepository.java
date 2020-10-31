package com.uzenetesztek.repository;

import com.uzenetesztek.domain.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    @Override
    List<Post> findAll();
}
