package com.banking.banksystem.service;

import com.banking.banksystem.dto.CustomerRequest;
import com.banking.banksystem.model.Customer;

import java.util.ArrayList;

public interface CustomerService {
    void salam();

    Customer addUser(CustomerRequest customerRequest);

    Customer findById(Long id);

    Customer findByUsername(String username);

    Customer findByEmail(String email);

    Customer findByPhone(String phone);

    Customer findByEmailOrPhone(String email, String phone);

    ArrayList<Customer> login();
}
