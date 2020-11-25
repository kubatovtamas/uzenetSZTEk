package com.uzenetesztek.service;

import com.uzenetesztek.domain.User;
import com.uzenetesztek.exceptions.DataIntegrityViolationException;
import com.uzenetesztek.exceptions.RecordNotFoundException;
import com.uzenetesztek.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService implements ICrudService<User, Long> {

    private UserRepository userRepo;
    @Autowired
    public void setUserRepo(UserRepository userRepo) {
        this.userRepo = userRepo;
    }



    @Override
    public List<User> getAll() {
        List<User> entities = (List<User>) userRepo.findAll();

        if (entities.size() > 0) {
            return entities;
        } else {
            return new ArrayList<User>();
        }
    }

    @Override
    public User getById(Long id) throws RecordNotFoundException {
        Optional<User> entity = userRepo.findById(id);

        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new RecordNotFoundException("User with id: " + id + " not found");
        }
    }

    @Override
    public void createOrUpdate(User entity) {
        if (entity.getId() == null) {
            /* Save New Entity */
            save(entity);

        } else {
            /* Edit Existing Entity */
            Optional<User> existingEntity = userRepo.findById(entity.getId());

            if (existingEntity.isPresent()) {
                User newEntity = existingEntity.get();
                newEntity.setAuthority(entity.getAuthority());
                newEntity.setDateOfBirth(entity.getDateOfBirth());
                newEntity.setEmail(entity.getEmail());
                newEntity.setFirstName(entity.getFirstName());
                newEntity.setLastName(entity.getLastName());
                newEntity.setFollowers(entity.getFollowers());
                newEntity.setFollows(entity.getFollows());
                newEntity.setFollowTopics(entity.getFollowTopics());
                newEntity.setLikedPosts(entity.getLikedPosts());
                newEntity.setTopics(entity.getTopics());
                newEntity.setProfilePicture(entity.getProfilePicture());
                newEntity.setPosts(entity.getPosts());
                newEntity.setLastLogin(entity.getLastLogin());
                newEntity.setPassword(entity.getPassword());

                save(newEntity);
            } else {
                save(entity);
            }
        }
    }

    @Override
    public void deleteById(Long id) throws RecordNotFoundException {
        Optional<User> entity = userRepo.findById(id);

        if(entity.isPresent()) {
            userRepo.deleteById(id);
        } else {
            throw new RecordNotFoundException("User with id: " + id + " not found");
        }
    }

    @Override
    public void save(User entity) throws RecordNotFoundException {
        try {
            userRepo.save(entity);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Data Integrity Validation");
        }
        // TODO: meaningful errors on specific cases
    }

    public void userFollowsUser(User user, User userToFollow) {

    }

    // returns optional for possible future use in UserDetails
    public Optional<User> findByEmail(String email) throws RecordNotFoundException {
        Optional<User> entity = userRepo.findByEmail(email);

        if (entity.isPresent()) {
            return entity;
        } else {
            throw new RecordNotFoundException("User with email: " + email + " not found");
        }
    }

    // returns User
    public User getByEmail(String email) throws RecordNotFoundException {
        Optional<User> entity = userRepo.findByEmail(email);

        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new RecordNotFoundException("User with email: " + email + " not found");
        }
    }
}

