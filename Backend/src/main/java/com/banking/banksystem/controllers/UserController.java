package com.banking.banksystem.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/register")
    public String registerNewUser(@RequestBody User user) {
        // Business logic to create a new user
        log.info(user.toString());
        return "User created: " + user;
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        // Business logic to get a user by ID
        log.info(user.toString());
        return "User details for user " + user;
    }


}
