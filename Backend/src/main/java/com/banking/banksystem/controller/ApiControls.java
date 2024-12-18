package com.banking.banksystem.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redirected/api")
public class ApiControls {

    private static final Logger log = LoggerFactory.getLogger(ApiControls.class);

    @PostMapping("/test")
    public String createItem(@RequestBody String item) {
        log.info(item);
        return item;
    }

}

