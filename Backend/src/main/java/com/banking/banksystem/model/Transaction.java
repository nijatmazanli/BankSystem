package com.banking.banksystem.model;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Date;

@Entity
@Table
@Data
public class Transaction {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private Integer account_id;
    private Integer transaction_id;
    private Date date;
    private boolean status;
    private Integer amount;
    private String currency;

    public Transaction(String currency, Date date, boolean status, Integer amount, Integer transaction_id, Integer account_id, String id) {
        this.currency = currency;
        this.date = date;
        this.status = status;
        this.amount = amount;
        this.transaction_id = transaction_id;
        this.account_id = account_id;
        this.id = id;
    }

    public Transaction() {

    }
}
