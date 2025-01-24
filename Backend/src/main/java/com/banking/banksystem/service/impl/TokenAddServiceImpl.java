package com.banking.banksystem.service.impl;

import com.banking.banksystem.dto.TokenAddrRequest;
import com.banking.banksystem.model.TokenAdd;
import com.banking.banksystem.repository.TokenAddRepository;
import com.banking.banksystem.service.TokenAddSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class TokenAddServiceImpl implements TokenAddSerivce {

    private final TokenAddRepository tokenAddRepository;


    public TokenAdd add(TokenAddrRequest tokenAddrRequest) {
        TokenAdd tokenAdd1 = new TokenAdd();
        tokenAdd1.setToken(tokenAddrRequest.getToken());
        tokenAdd1.setType(tokenAddrRequest.getType());
        tokenAdd1.setFin_code(tokenAddrRequest.getFin_code());
        tokenAdd1.setCreated_at_back(new Date());
        tokenAdd1.setCreated_at_in_front(tokenAddrRequest.getCreated_at_in_front());
        tokenAddRepository.save(tokenAdd1);
        return tokenAdd1;
    }


    @Override
    public TokenAdd addtoken(TokenAddrRequest tokenAddrRequest) {
        return null;
    }
}
