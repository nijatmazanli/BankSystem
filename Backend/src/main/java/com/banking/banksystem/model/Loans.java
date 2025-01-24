package com.banking.banksystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table
@Data
public class Loans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer account_id;
    private Integer loans_id;
    private Integer interest_rate;
    private Integer customer_id;

    private Date created_date;
    private Date due_date;
    private Integer first_amount;
    private Integer second_amount;

    private enum status {}
}
