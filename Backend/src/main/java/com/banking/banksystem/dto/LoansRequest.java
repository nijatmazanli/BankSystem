package com.banking.banksystem.dto;

import java.sql.Date;

public class LoansRequest {
    private Integer account_id;
    private Integer loans_id;
    private Integer interest_rate;
    private Integer customer_id;

    private Date created_date;
    private Date due_date;
    private Integer first_amount;
    private Integer second_amount;
    private enum status {}

    private enum loan_types {}

}

