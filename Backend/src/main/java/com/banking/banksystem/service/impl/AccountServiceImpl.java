package com.banking.banksystem.service.impl;

import com.banking.banksystem.model.Account;
import com.banking.banksystem.service.AccountService;

import java.sql.Date;

public class AccountServiceImpl implements AccountService {
    @Override
    public void deposit(double amount) {
        System.out.println("deposited to account.");
        Account account = new Account(21212,new Date(2004,11,12),new Date(2001,11,12),"NIJAT MAZANLI","41414141414141");
        System.out.println(account);


    }
}
