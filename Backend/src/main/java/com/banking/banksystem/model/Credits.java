package com.banking.banksystem.model;

import com.banking.banksystem.enums.credit.CreditStatusEnum;
import com.banking.banksystem.enums.credit.CreditTypesEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table
@Data
public class Credits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer credits_id;
    private Integer account_id;
    private Integer customer_id;
    private Integer interest_rate;
    private CreditStatusEnum status;
    private Integer customer_id_2;
    private Integer credit_limit;
    private Integer balance;
    private Date created_date;
    private CreditTypesEnum credit_type;

}
