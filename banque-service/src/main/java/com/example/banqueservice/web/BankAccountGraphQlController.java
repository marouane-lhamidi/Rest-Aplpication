package com.example.banqueservice.web;

import com.example.banqueservice.dto.BankAccountRequestDto;
import com.example.banqueservice.dto.BankAccountResponseDto;
import com.example.banqueservice.entities.BankAccount;
import com.example.banqueservice.repositories.BankRepository;
import com.example.banqueservice.services.IBankAccount;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller @AllArgsConstructor
public class BankAccountGraphQlController {
    BankRepository bankRepository;
    IBankAccount iBankAccount;

    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankRepository.findAll();
    }

    @QueryMapping
    public BankAccount accountById(@Argument String id){
        return bankRepository.findById(id).orElseThrow(()->
                new RuntimeException(String.format("Account %s not found", id))
        );
    }

    @MutationMapping
    public BankAccountResponseDto addAccount(@Argument BankAccountRequestDto accountDto){
        return iBankAccount.addAccount(accountDto);
    }

    @MutationMapping
    public BankAccountResponseDto updateAccount(@Argument String id,@Argument BankAccountRequestDto accountDto){
        return iBankAccount.updateAccounts(id, accountDto);
    }

    @MutationMapping
    public void deleteAccount(@Argument String id){
        iBankAccount.delete(id);
    }
}
