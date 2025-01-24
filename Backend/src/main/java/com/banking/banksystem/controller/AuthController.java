package com.banking.banksystem.controller;

import com.banking.banksystem.dto.CustomerRequest;
import com.banking.banksystem.service.CustomerService;
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
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private CustomerService customerService;

    @PostMapping("/test")
    public String createItem(@RequestBody CustomerRequest customerRequest) {
//        log.info(customerRequest);
        customerService.salam();
        return customerRequest.toString();
    }
}
