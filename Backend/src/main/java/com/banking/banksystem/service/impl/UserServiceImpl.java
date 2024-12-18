package com.banking.banksystem.service.impl;

import com.banking.banksystem.model.User;
import com.banking.banksystem.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public  void salam(){
        System.out.println("salam");
        User user = new User();

    }

}
