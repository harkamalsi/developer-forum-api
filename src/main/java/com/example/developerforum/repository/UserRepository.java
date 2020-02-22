package com.example.developerforum.repository;

import com.example.developerforum.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    User findByNameStartingWith(String name);

    User findByEmail(String email);

    Optional<User> findById(String id);

}
