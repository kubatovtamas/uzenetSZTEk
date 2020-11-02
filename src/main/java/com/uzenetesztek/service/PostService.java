package com.uzenetesztek.service;

import com.uzenetesztek.domain.Post;
import com.uzenetesztek.domain.User;
import com.uzenetesztek.exceptions.RecordNotFoundException;
import com.uzenetesztek.repository.PostRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class PostService {
    private PostRepository postRepo;

    @Autowired
    public void setPostRepo(PostRepository postRepo) {

        this.postRepo = postRepo;
    }

    public List<Post> getPostsByUser(User user) throws RecordNotFoundException {
        List<Post> post = postRepo.findAllByUser(user);

        if (post == null) {
            throw new RecordNotFoundException("The user has no posts");
        } else {
            return post;
        }
    }
}
