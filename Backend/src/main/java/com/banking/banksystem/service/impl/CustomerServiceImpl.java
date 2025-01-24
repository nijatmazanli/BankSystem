package com.banking.banksystem.service.impl;

import com.banking.banksystem.dto.CustomerRequest;
import com.banking.banksystem.model.Customer;
import com.banking.banksystem.repository.CustomerRepository;
import com.banking.banksystem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;


    @Override
    public void salam() {
        System.out.println("salam");
        Customer customer = new Customer();

    }

    @Override
    public Customer addUser(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setName(customerRequest.getName());
        customer.setSurname(customerRequest.getSurname());
        customer.setFin_code(customerRequest.getFin_code());
        customer.setEmail(customerRequest.getEmail());
        customer.setPassword(customerRequest.getPassword());
        customer.setPhoneNumber(customerRequest.getPhoneNumber());
        customer.setBirthDate(customerRequest.getBirthDate());
        customer.setRegisterDate(customerRequest.getRegisterDate());
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public Customer findById(Long id) {
        return null;
    }

    @Override
    public Customer findByUsername(String username) {
        return null;
    }

    @Override
    public Customer findByEmail(String email) {
        return null;
    }

    @Override
    public Customer findByPhone(String phone) {
        return null;
    }

    @Override
    public Customer findByEmailOrPhone(String email, String phone) {
        return null;
    }


    @Override
    public ArrayList<Customer> login() {
        return (ArrayList<Customer>) customerRepository.findAll();
    }

}
