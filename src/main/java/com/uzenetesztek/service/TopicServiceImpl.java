package com.uzenetesztek.service;

import com.uzenetesztek.domain.Post;
import com.uzenetesztek.domain.Topic;
import com.uzenetesztek.domain.User;
import com.uzenetesztek.exceptions.DataIntegrityViolationException;
import com.uzenetesztek.exceptions.RecordNotFoundException;
import com.uzenetesztek.repository.TopicRepository;
import com.uzenetesztek.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TopicServiceImpl implements CrudServiceInterface<Topic, Long> {

    private TopicRepository topicRepo;
    @Autowired
    public void setTopicRepo(TopicRepository topicRepo) {
        this.topicRepo = topicRepo;
    }

    private UserRepository userRepo;
    @Autowired
    public void setUserRepo(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    private PostServiceImpl postServ;
    @Autowired
    public void setPostService(PostServiceImpl postServ) {
        this.postServ = postServ;
    }



    @Override
    public List<Topic> getAll() {
        List<Topic> entities = (List<Topic>) topicRepo.findAll();

        if (entities.size() > 0) {
            return entities;
        } else {
            return new ArrayList<Topic>();
        }
    }

    @Override
    public Topic getById(Long id) throws RecordNotFoundException {
        Optional<Topic> entity = topicRepo.findById(id);

        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new RecordNotFoundException("Topic with id: " + id + " not found");
        }
    }

    @Override
    public void createOrUpdate(Topic entity) {
        if (entity.getId() == null) {
            /* Save New Entity */
            save(entity);

        } else {
            /* Edit Existing Entity */
            Optional<Topic> existingEntity = topicRepo.findById(entity.getId());

            if (existingEntity.isPresent()) {
                Topic newEntity = existingEntity.get();
                newEntity.setDescription(entity.getDescription());
                newEntity.setFollowers(entity.getFollowers());
                newEntity.setName(entity.getName());
                newEntity.setPosts(entity.getPosts());
                newEntity.setTimestamp(entity.getTimestamp());
                newEntity.setUser(entity.getUser());

                save(newEntity);
            } else {
                save(entity);
            }
        }
    }

    @Override
    public void deleteById(Long id) throws RecordNotFoundException {
        Optional<Topic> entity = topicRepo.findById(id);

        if(entity.isPresent()) {
            topicRepo.deleteById(id);
        } else {
            throw new RecordNotFoundException("Topic with id: " + id + " not found");
        }
    }

    @Override
    public void save(Topic entity) throws RecordNotFoundException {
        try {
            topicRepo.save(entity);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Data Integrity Validation");
        }
        // TODO: meaningful errors on specific cases
    }

    public List<Topic> getAllTopicsOrdered() {
        List<Topic> entities = (List<Topic>) topicRepo.findAllByOrderByNameAsc();

        if (entities.size() > 0) {
            return entities;
        } else {
            return new ArrayList<Topic>();
        }
    }

    public List<Topic> getAllTopicsOrdered(User user) {
        List<Topic> entities = (List<Topic>) topicRepo.findAllByUserOrderByTimestampAsc(user);

        if (entities.size() > 0) {
            return entities;
        } else {
            return new ArrayList<Topic>();
        }
    }
}
