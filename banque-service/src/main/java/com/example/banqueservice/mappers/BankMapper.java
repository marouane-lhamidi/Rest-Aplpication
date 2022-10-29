package com.example.banqueservice.mappers;

import com.example.banqueservice.dto.BankAccountRequestDto;
import com.example.banqueservice.dto.BankAccountResponseDto;
import com.example.banqueservice.entities.BankAccount;

import java.util.Date;
import java.util.UUID;

public class BankMapper {
    public static BankAccount fromBankRequest(BankAccountRequestDto accountRequestDto){
        return BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .currency(accountRequestDto.getCurrency())
                .balance(accountRequestDto.getBalance())
                .type(accountRequestDto.getType())
                .createdAt(new Date())
                .build();
    }
    public static BankAccountResponseDto fromBank(BankAccount accountRequestDto){
        return BankAccountResponseDto.builder()
                .id(accountRequestDto.getId())
                .currency(accountRequestDto.getCurrency())
                .balance(accountRequestDto.getBalance())
                .createdAt(accountRequestDto.getCreatedAt())
                .type(accountRequestDto.getType())
                .build();
    }
}
