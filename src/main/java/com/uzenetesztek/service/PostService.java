package com.uzenetesztek.service;

import com.uzenetesztek.repository.PostRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class PostService {
    PostRepository postRepo;

    @Autowired
    public void setPostRepo(PostRepository postRepo) {
        this.postRepo = postRepo;
    }
}
