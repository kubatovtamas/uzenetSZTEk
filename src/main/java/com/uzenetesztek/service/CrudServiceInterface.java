package com.uzenetesztek.service;

import com.uzenetesztek.exceptions.RecordNotFoundException;
import com.uzenetesztek.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public interface CrudServiceInterface<Type, IdType> {
    public List<Type> getAll();

    public Type getById(IdType id) throws RecordNotFoundException;

    public void createOrUpdate(Type entity);

    public void deleteById(IdType id) throws RecordNotFoundException;

    public void save(Type entity) throws RecordNotFoundException;
}
