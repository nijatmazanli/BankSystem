package com.banking.banksystem.controller;

import com.banking.banksystem.dto.CustomerRequest;
import com.banking.banksystem.model.Customer;
import com.banking.banksystem.repository.CustomerRepository;
import com.banking.banksystem.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody CustomerRequest customerRequest) {
        ArrayList<Customer> getUser = customerService.login();
        for (Customer customers : getUser) {
            if (customers != null) {
                String customerFinCode = customers.getFin_code();
                String customerEmail = customers.getEmail();
                if (customerFinCode != null && customerFinCode.equals(customerRequest.getFin_code())) {
                    if (customerEmail != null && customerEmail.equals(customerRequest.getEmail())) {
                        return ResponseEntity.ok("User Exists");
                    } else {
                        return ResponseEntity.ok("Mail used before");
                    }
                }
            }
        }
        Customer createdCustomer = customerService.addUser(customerRequest);

        return ResponseEntity.ok(createdCustomer);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Customer customer) {
        // Business logic to get a customer by ID
        log.info(customer.toString());
        ArrayList<Customer> getUser = customerService.login();
        String fincode = customer.getFin_code();
        System.out.println(fincode);
        log.info(getUser.toString());
        boolean userFound = false;

        for (Customer customers : getUser) {

            if (customers != null) {
                log.info(customers.toString());
                String customerFinCode = customers.getFin_code();
                String customerPassword = customers.getPassword();

                if (fincode.equals(customerFinCode)) {
                    if (customerPassword != null && customerPassword.equals(customer.getPassword())) {

                        userFound = true;
                        return ResponseEntity.ok(customers);

                    }
                }
            }
        }
        if (!userFound) {
            return ResponseEntity.ok("Get data");
        }
        return ResponseEntity.ok("!@12");
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        List<Customer> customers = customerRepository.findAll();
        return ResponseEntity.ok(customers);
    }


}
