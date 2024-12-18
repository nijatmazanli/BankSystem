package com.banking.banksystem.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class AccountRequest {
    private Integer customer_id;
    private Integer account_id;
    private Date created_date;
    private Date updated_date;
    private String account_name;
    private String card_number;
}
