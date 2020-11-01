package com.uzenetesztek.service;

import com.uzenetesztek.domain.User;
import com.uzenetesztek.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class UserService {
    UserRepository userRepo;

    @Autowired
    public void setUserRepo(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User getSpecificUser(String email){
        return userRepo.findByEmail(email);
    }
}

