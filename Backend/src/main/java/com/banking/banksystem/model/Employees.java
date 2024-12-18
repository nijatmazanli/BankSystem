package com.banking.banksystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Employees {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employees_id;
    private String name;
    private String email;
    private Integer branch_id;

    public Employees(String name, String email, Integer branch_id) {
        this.name = name;
        this.email = email;
        this.branch_id = branch_id;
    }

    public Employees() {

    }
}
