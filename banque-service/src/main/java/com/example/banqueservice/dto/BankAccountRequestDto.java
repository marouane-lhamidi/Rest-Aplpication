package com.example.banqueservice.dto;

import com.example.banqueservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccountRequestDto {
    private Double balance;
    private String currency;
    private AccountType type;
}
