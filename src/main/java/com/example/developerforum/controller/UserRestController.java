package com.example.developerforum.controller;

import com.example.developerforum.dto.UserDTO;
import com.example.developerforum.model.User;
import com.example.developerforum.service.UserService;
import com.example.developerforum.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public List<UserDTO> getAllUsers() {
        return ObjectMapperUtils.mapAll(userService.findAll(), UserDTO.class);
    }

    @GetMapping(value = "/byEmail/{email}")
    public UserDTO getUserByEmail(@PathVariable("email") String email) {
        return ObjectMapperUtils.map(userService.findByEmail(email), UserDTO.class);
    }

    @GetMapping(value = "/byName/{name}")
    public UserDTO getUserByName(@PathVariable("name") String name) {
        return ObjectMapperUtils.map(userService.findByNameStartingWith(name), UserDTO.class);
    }

    @GetMapping(value = "/byId/{id}")
    public UserDTO getUserById(@PathVariable("id") String id) {
        return ObjectMapperUtils.map(userService.findById(id), UserDTO.class);
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> saveOrUpdateUser(@RequestBody UserDTO userDTO) {
        userService.saveOrUpdateUser(ObjectMapperUtils.map(userDTO, User.class));
        return new ResponseEntity("User added successfully", HttpStatus.OK);
    }

}
