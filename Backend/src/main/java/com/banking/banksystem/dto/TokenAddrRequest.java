package com.banking.banksystem.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TokenAddrRequest {
    private String token;
    private String type;
    private String fin_code;
    private Date created_at_in_front;
    private Date created_at_back;

}
