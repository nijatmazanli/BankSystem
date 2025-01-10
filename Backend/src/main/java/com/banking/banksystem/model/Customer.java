package com.banking.banksystem.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

@Entity
@Table
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String fin_code;
    private String name;
    private String surname;
    private String email;
    private String password;

    public Customer() {

    }
}

