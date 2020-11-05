package com.uzenetesztek.service;

import com.uzenetesztek.domain.User;
import com.uzenetesztek.exceptions.RecordNotFoundException;
import com.uzenetesztek.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Data
@Service
public class UserService {
    private UserRepository userRepo;

    @Autowired
    public void setUserRepo(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User getUserByEmail(String email) throws RecordNotFoundException {
        User user = userRepo.findByEmail(email);

        if (user == null) {
            throw new RecordNotFoundException("No user found with email: " + email);
        } else {
            return user;
        }
    }

    @PostConstruct
    public void init() {
        User user = new User("test", "xd", false);
        userRepo.save(user);
    }
}

