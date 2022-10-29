package com.example.banqueservice.services;

import com.example.banqueservice.dto.BankAccountRequestDto;
import com.example.banqueservice.dto.BankAccountResponseDto;
import com.example.banqueservice.entities.BankAccount;


import java.util.List;

public interface IBankAccount {
    BankAccountResponseDto addAccount(BankAccountRequestDto accountRequestDto);
    List<BankAccountResponseDto> getAccounts();
    BankAccountResponseDto getAccount(String id);
    BankAccountResponseDto updateAccounts(String id,BankAccountRequestDto bankAccount);
    void delete( String id);
}
