package com.banking.banksystem.dto;

import lombok.Data;

@Data
public class EmployeesRequest {
    private String name;
    private String email;
    private Integer branch_id;
}
