package com.banking.banksystem.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiControls {

    private static final Logger log = LoggerFactory.getLogger(ApiControls.class);

    @PostMapping("/test")
    public String createItem(@RequestBody String item) {
        log.info(item);
        return item;
    }

}

