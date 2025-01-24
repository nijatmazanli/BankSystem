package com.banking.banksystem.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;

@Entity
@Table
@Data
@Getter
@Setter
public class TokenAdd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String token;
    private String type;
    private String fin_code;
    private Date created_at_in_front;
    private Date created_at_back;

    public TokenAdd() {

    }
}
