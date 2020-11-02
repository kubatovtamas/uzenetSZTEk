package com.uzenetesztek.service;

import com.uzenetesztek.domain.Post;
import com.uzenetesztek.domain.Topic;
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

    public List<Post> getPostsByUserOrdered(User user) throws RecordNotFoundException {
        List<Post> post = postRepo.findAllByUserOrderByTimestampAsc(user);

        if (post == null) { // || post.size() == 0 -> causes 500 internal server error in thymeleaf
            throw new RecordNotFoundException("The user has no posts"); // never happens
        } else {
            return post;
        }
    }

    public List<Post> getPostsOrdered(Topic topic) throws RecordNotFoundException {
        List<Post> post = postRepo.findAllByParentTopicOrderByTimestampAsc(topic);

        if (post == null) {
            throw new RecordNotFoundException("The user has no posts");
        } else {
            return post;
        }
    }
}
