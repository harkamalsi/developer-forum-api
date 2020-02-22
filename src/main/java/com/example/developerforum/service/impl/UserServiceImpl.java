package com.example.developerforum.service.impl;

import com.example.developerforum.model.User;
import com.example.developerforum.repository.UserRepository;
import com.example.developerforum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByNameStartingWith(String name) {
        return userRepository.findByNameStartingWith(name);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User saveOrUpdateUser(User user) {
        return userRepository.save(user);
    }
}
