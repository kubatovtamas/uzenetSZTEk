package com.uzenetesztek.repository;

import com.uzenetesztek.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Override
    List<User> findAll();

    User findByEmail(String email);  // JPA generated

//    @Query(value = "SELECT * FROM USER WHERE email = ?1 limit 1", nativeQuery = true) // native SQL 1
//    User findByEmail(String email);

//    @Query(value = "SELECT * FROM USER WHERE email = :email limit 1", nativeQuery = true)  // native SQL 2
//    User findByEmail(@Param("email") String email);
}
