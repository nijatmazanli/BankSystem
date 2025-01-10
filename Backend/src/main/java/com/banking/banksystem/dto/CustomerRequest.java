package com.banking.banksystem.dto;

import lombok.Data;


@Data
public class CustomerRequest {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String fin_code;
}
