package com.uzenetesztek.service;

import com.uzenetesztek.domain.Post;
import com.uzenetesztek.domain.Topic;
import com.uzenetesztek.domain.User;
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



    public List<Post> getPostsByTopicOrdered(Topic topic) {

        // user should check if return value is empty list
        return postRepo.findAllByParentTopicOrderByTimestampDesc(topic);
    }

    public List<Post> getPostsByUserOrdered(User user) {

        // user should check if return value is empty list
        return postRepo.findAllByUserOrderByTimestampDesc(user);
    }


}
