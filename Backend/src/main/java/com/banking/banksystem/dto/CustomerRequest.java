package com.banking.banksystem.dto;

import lombok.Data;

import java.sql.Date;


@Data
public class CustomerRequest {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String fin_code;
    private Integer phoneNumber;
    private Date birthDate;
    private Date registerDate;

}
