package com.banking.banksystem.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;

public class Loans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer account_id;
    private Integer loans_id;
    private Integer interest_rate;
    private enum status{};
    private Integer customer_id;
    private Date created_date;
    private Date due_date;
    private Integer first_amount;
    private Integer second_amount;
    private enum loan_types{};
}
