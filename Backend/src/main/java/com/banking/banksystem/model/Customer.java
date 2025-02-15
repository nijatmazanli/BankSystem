package com.banking.banksystem.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Entity
@Table
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    private String surname;
    private String email;
    private String password;
    private String fin_code;
    private Integer phoneNumber;
    private Date birthDate;
    private Date registerDate;


    public Customer() {

    }
}

