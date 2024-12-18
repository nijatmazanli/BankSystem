package com.banking.banksystem.controller;

import com.banking.banksystem.dto.UserRequest;
import com.banking.banksystem.model.User;
import com.banking.banksystem.repository.UserRepository;
import com.banking.banksystem.service.UserService;
import com.banking.banksystem.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    private static final Logger log = LoggerFactory.getLogger(UserController.class);



    @PostMapping("/register")
    public User createUser(@RequestBody UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        System.out.println(userRequest);
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        // Business logic to get a user by ID
        log.info(user.toString());
        return "User details for user " + user;
    }


}
