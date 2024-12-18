package com.banking.banksystem.dto;

import lombok.Data;


@Data
public class UserRequest {
    private String name;
    private String surname;
    private String email;
}
