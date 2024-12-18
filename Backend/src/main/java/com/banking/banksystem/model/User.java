package com.banking.banksystem.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Table
@Data
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String surname;
    private String email;


}

