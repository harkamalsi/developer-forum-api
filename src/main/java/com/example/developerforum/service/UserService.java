package com.example.developerforum.service;

import com.example.developerforum.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    User findByNameStartingWith(String name);

    User findByEmail(String email);

    Optional<User> findById(String id);

    User saveOrUpdateUser(User user);

}
