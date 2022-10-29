package com.example.banqueservice.dto;

import com.example.banqueservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccountResponseDto {
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    private AccountType type;
}
