package com.uzenetesztek.repository;

import com.uzenetesztek.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface UserRepository extends CrudRepository<User, Long> {
    @Override
    ArrayList<User> findAll();
}
