package com.uzenetesztek.service;

import com.uzenetesztek.exceptions.DataIntegrityViolationException;
import com.uzenetesztek.exceptions.RecordNotFoundException;
import com.uzenetesztek.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ICrudService<Type, IdType> {

    /**
     *
     * @return All Entities
     */
    public List<Type> getAll();

    /**
     *
     * @param id Entity ID
     * @return Entity By ID
     * @throws RecordNotFoundException When No Entity Is Found With ID
     */
    public Type getById(IdType id) throws RecordNotFoundException;

    /**
     * Save A New Entity, Or Edit An Existing One
     * @param entity Entity To Be Saved
     */
    public void createOrUpdate(Type entity);

    /**
     *
     * @param id Entity ID
     * @throws RecordNotFoundException When No Entity Is Found With ID
     */
    public void deleteById(IdType id) throws RecordNotFoundException;

    /**
     * For Internal Service Use Only In createOrUpdate()
     * @param entity Entity To Be Saved
     * @throws DataIntegrityViolationException When The Entity Cannot Be Saved Because Of Database Restrictions
     */
    public void save(Type entity) throws DataIntegrityViolationException;
}
