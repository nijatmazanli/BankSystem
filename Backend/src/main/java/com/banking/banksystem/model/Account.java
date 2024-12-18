package com.banking.banksystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
@Entity
@Table
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_id;

    private Integer account_id;
    private Date created_date;
    private Date updated_date;
    private String account_name;
    private String card_number;

    public Account( Integer account_id, Date updated_date, Date created_date, String account_name, String card_number) {
        this.account_id = account_id;
        this.updated_date = updated_date;
        this.created_date = created_date;
        this.account_name = account_name;
        this.card_number = card_number;
    }

    public Account() {

    }

    @Override
    public String toString() {
        return "AccountRepository{" +
                "customer_id=" + customer_id +
                ", account_id=" + account_id +
                ", created_date=" + created_date +
                ", updated_date=" + updated_date +
                ", account_name='" + account_name + '\'' +
                ", card_number='" + card_number + '\'' +
                '}';
    }


}
