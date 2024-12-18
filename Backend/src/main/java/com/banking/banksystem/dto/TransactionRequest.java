package com.banking.banksystem.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class TransactionRequest {
    private Integer account_id;
    private Integer transaction_id;
    private Date date;
    private boolean status;
    private Integer amount;
    private String currency;
}
