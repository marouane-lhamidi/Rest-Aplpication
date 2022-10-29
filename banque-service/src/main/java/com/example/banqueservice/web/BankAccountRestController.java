package com.example.banqueservice.web;

import com.example.banqueservice.dto.BankAccountRequestDto;
import com.example.banqueservice.dto.BankAccountResponseDto;
import com.example.banqueservice.entities.BankAccount;
import com.example.banqueservice.services.IBankAccount;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BankAccountRestController {
    IBankAccount iBankAccount;

    @GetMapping("bankAccounts")
    public List<BankAccountResponseDto> getAccounts(){
        return iBankAccount.getAccounts();
    }

    @GetMapping("bankAccount/{id}")
    public BankAccountResponseDto getAccount(@PathVariable String id){
        return iBankAccount.getAccount(id);
    }

    @PostMapping("bankAccount")
    public BankAccountResponseDto addAccount(@RequestBody BankAccountRequestDto bankAccount){
        return iBankAccount.addAccount(bankAccount);
    }

    @PutMapping("bankAccount/{id}")
    public BankAccountResponseDto updateAccounts(@PathVariable String id,@RequestBody BankAccountRequestDto bankAccount){

        return iBankAccount.updateAccounts(id, bankAccount);
    }

    @DeleteMapping("bankAccount/{id}")
    public void delete(@PathVariable String id){
        iBankAccount.delete(id);
    }


}
