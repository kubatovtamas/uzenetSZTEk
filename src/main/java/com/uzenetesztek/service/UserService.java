package com.uzenetesztek.service;

import com.uzenetesztek.exceptions.RecordNotFoundException;
import com.uzenetesztek.domain.User;
import com.uzenetesztek.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

@Data
@Service
public class UserService {
    private UserRepository userRepo;

    @Autowired
    public void setUserRepo(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User getSpecificUser(String email) throws RecordNotFoundException{
        User u = userRepo.findByEmail(email);

        if (u == null) {
            throw new RecordNotFoundException("No user found with email: " + email);
        } else {
            return userRepo.findByEmail(email);
        }
    }


    @PostConstruct
    public void init() {
        User user = new User("test", "xd", false);
        userRepo.save(user);
    }
}

