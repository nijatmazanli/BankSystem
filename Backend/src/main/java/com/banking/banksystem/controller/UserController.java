package com.banking.banksystem.controller;

import com.banking.banksystem.dto.CustomerRequest;
import com.banking.banksystem.dto.TokenAddrRequest;
import com.banking.banksystem.model.Customer;
import com.banking.banksystem.model.TokenAdd;
import com.banking.banksystem.repository.CustomerRepository;
import com.banking.banksystem.repository.TokenAddRepository;
import com.banking.banksystem.service.CustomerService;
import com.banking.banksystem.service.TokenAddSerivce;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TokenAddRepository tokenAddRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private TokenAddSerivce tokenAddSerivce;

    @Autowired
    private HandlerMapping resourceHandlerMapping;

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody CustomerRequest customerRequest) {
        ArrayList<Customer> getUser = customerService.login();
        for (Customer customers : getUser) {
            if (customers != null) {
                String customerFinCode = customers.getFin_code();
                String customerEmail = customers.getEmail();
                Integer customerPhone = customers.getPhoneNumber();
                if (customerFinCode.equals(customerRequest.getFin_code())) {
                    return ResponseEntity.ok("FIN used before");
                }
                if (customerEmail != null && customerEmail.equals(customerRequest.getEmail())) {
                    return ResponseEntity.ok("Mail used before");
                }
                if (customerPhone.equals(customerRequest.getPhoneNumber())) {
                    return ResponseEntity.ok("Phone used before");
                }
            }
        }
        Customer createdCustomer = customerService.addUser(customerRequest);


        return ResponseEntity.ok("User created.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Customer customer) {
        log.info(customer.toString());
        ArrayList<Customer> getUser = customerService.login();
        String fincode = customer.getFin_code();
        log.info(getUser.toString());

        for (Customer customers : getUser) {
            log.info(customers.toString());
            String customerFinCode = customers.getFin_code();
            String customerPassword = customers.getPassword();

            if (fincode.equals(customerFinCode)) {
                if (customerPassword != null && customerPassword.equals(customer.getPassword())) {
                    return ResponseEntity.ok(customers);
                }
                return ResponseEntity.ok("Invalid Password");
            }
        }
        return ResponseEntity.ok("FIN Code not found");
    }

    @PostMapping("/login/addToken")
    public ResponseEntity<?> addTokenToDb(@RequestBody TokenAddrRequest tokenAdd) {

        TokenAdd newToken = tokenAddSerivce.add(tokenAdd);
        log.info(newToken.toString());
        return ResponseEntity.ok("Token added");
    }



}
