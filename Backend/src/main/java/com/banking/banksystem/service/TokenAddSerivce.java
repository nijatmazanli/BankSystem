package com.banking.banksystem.service;

import com.banking.banksystem.dto.TokenAddrRequest;
import com.banking.banksystem.model.TokenAdd;

public interface TokenAddSerivce {
    TokenAdd addtoken(TokenAddrRequest tokenAddrRequest);

    TokenAdd add(TokenAddrRequest tokenAdd);
}
