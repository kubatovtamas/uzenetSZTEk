package com.uzenetesztek.repository;

import com.uzenetesztek.domain.testPOJO;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface testPOJORepository extends CrudRepository<testPOJO, Long> {
    @Override
    ArrayList<testPOJO> findAll();
}


