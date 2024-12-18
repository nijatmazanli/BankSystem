package com.banking.banksystem.controller;

import com.banking.banksystem.dto.UserRequest;
import com.banking.banksystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private static final Logger log = LoggerFactory.getLogger(ApiControls.class);
@Autowired
private UserService userService;
    @PostMapping("/test")
    public String createItem(@RequestBody UserRequest userRequest) {
//        log.info(userRequest);
userService.salam();
    return userRequest.toString();
    }
}
