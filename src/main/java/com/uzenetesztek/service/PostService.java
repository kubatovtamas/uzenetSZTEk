package com.uzenetesztek.service;

import com.uzenetesztek.domain.Post;
import com.uzenetesztek.domain.Topic;
import com.uzenetesztek.domain.User;
import com.uzenetesztek.repository.PostRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Data
@Service
public class PostService {
    private PostRepository postRepo;

    @Autowired
    public void setPostRepo(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    // basic idea of how internally created post function might work
//    public void init() {
//        User user = new User("ijustwantto@register", "thisismypassword", false);
//        Topic topic = new Topic("New Topic", new Date(), user);
//        Post post = new Post("I wrote a story today", new Date(), user, topic);
//        postRepo.save(post);
//    }
}
