package com.uzenetesztek.service;

import com.uzenetesztek.Exceptions.RecordNotFoundException;
import com.uzenetesztek.domain.User;
import com.uzenetesztek.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public User getSpecificUser(String email) throws RecordNotFoundException{
        User u = userRepo.findByEmail(email);

        if (u == null) {
            throw new RecordNotFoundException("No user found with email: " + email);
        } else {
            return userRepo.findByEmail(email);
        }
    }
}

