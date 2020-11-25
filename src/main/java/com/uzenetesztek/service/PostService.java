package com.uzenetesztek.service;

import com.uzenetesztek.domain.Post;
import com.uzenetesztek.domain.Topic;
import com.uzenetesztek.exceptions.DataIntegrityViolationException;
import com.uzenetesztek.exceptions.RecordNotFoundException;
import com.uzenetesztek.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PostService implements ICrudService<Post, Long> {

    private PostRepository postRepo;
    @Autowired
    public void setPostRepo(PostRepository postRepo) { this.postRepo = postRepo; }



    @Override
    public List<Post> getAll() {
        List<Post> entities = (List<Post>) postRepo.findAll();

        if (entities.size() > 0) {
            return entities;
        } else {
            return new ArrayList<Post>();
        }
    }

    @Override
    public Post getById(Long id) throws RecordNotFoundException {
        Optional<Post> entity = postRepo.findById(id);

        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new RecordNotFoundException("Post with id: " + id + " not found");
        }
    }

    @Override
    public void createOrUpdate(Post entity) {
        if (entity.getId() == null) {
            /* Save New Entity */
            save(entity);

        } else {
            /* Edit Existing Entity */
            Optional<Post> existingEntity = postRepo.findById(entity.getId());

            if (existingEntity.isPresent()) {
                Post newEntity = existingEntity.get();
                newEntity.setUser(entity.getUser());
                newEntity.setFile(entity.getFile());
                newEntity.setParentTopic(entity.getParentTopic());
                newEntity.setReplyPosts(entity.getReplyPosts());
                newEntity.setStarterPost(entity.getStarterPost());
                newEntity.setTextContent(entity.getTextContent());
                newEntity.setTimestamp(entity.getTimestamp());
                newEntity.setUserLikes(entity.getUserLikes());

                save(newEntity);
            } else {
                save(entity);
            }
        }
    }

    @Override
    public void deleteById(Long id) throws RecordNotFoundException {
        Optional<Post> entity = postRepo.findById(id);

        if(entity.isPresent()) {
            postRepo.deleteById(id);
        } else {
            throw new RecordNotFoundException("Post with id: " + id + " not found");
        }
    }

    @Override
    public void save(Post entity) throws DataIntegrityViolationException {
        try {
            postRepo.save(entity);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Data Integrity Validation");
        }
        // TODO: meaningful errors on specific cases
    }

    public List<Post> getPostsByTopicOrdered(Topic topic) {
        List<Post> entities = (List<Post>) postRepo.findAllByParentTopicOrderByTimestampDesc(topic);

        if (entities.size() > 0) {
            return entities;
        } else {
            return new ArrayList<Post>();
        }
    }
}
