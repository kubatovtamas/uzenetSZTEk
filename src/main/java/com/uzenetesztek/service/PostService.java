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

    private List<Post> getPosts() {
        return postRepo.findAllByOrderByTimestampDesc();
    }

    public List<Post> getPostsByUserOrdered(User user) {

        // user should check if return value is empty list
        return postRepo.findAllByUserOrderByTimestampAsc(user);
    }

    public List<Post> getPostsOrdered(Topic topic) {

        // user should check if return value is empty list
        return postRepo.findAllByParentTopicOrderByTimestampAsc(topic);
    }
}
