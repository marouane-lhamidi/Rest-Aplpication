package com.example.banqueservice.services;

import com.example.banqueservice.dto.BankAccountRequestDto;
import com.example.banqueservice.dto.BankAccountResponseDto;
import com.example.banqueservice.entities.BankAccount;
import com.example.banqueservice.mappers.BankMapper;
import com.example.banqueservice.repositories.BankRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class IBankAccountImpl implements IBankAccount {
    BankRepository bankRepository;

    @Override
    public List<BankAccountResponseDto> getAccounts() {
        List<BankAccount> accounts = bankRepository.findAll();
        return accounts.stream().map(BankMapper::fromBank).collect(Collectors.toList());
    }

    @Override
    public BankAccountResponseDto getAccount(String id) {
        BankAccount account = bankRepository.findById(id).orElseThrow(()->
                new RuntimeException(String.format("Account %s not found", id))
        );
        return BankMapper.fromBank(account);
    }

    @Override
    public BankAccountResponseDto addAccount(BankAccountRequestDto accountRequestDto) {
        BankAccount bankAccount = BankMapper.fromBankRequest(accountRequestDto);

        return BankMapper.fromBank(bankRepository.save(bankAccount));
    }

    @Override
    public BankAccountResponseDto updateAccounts(String id, BankAccountRequestDto bankAccount) {
        BankAccount account = bankRepository.findById(id).orElseThrow(()->
                new RuntimeException(String.format("Account %s not found", id))
        );

        if (bankAccount.getType() != null)
            account.setType(bankAccount.getType() );
        if (bankAccount.getBalance() != null)
            account.setBalance(bankAccount.getBalance() );
        if (bankAccount.getCurrency() != null)
            account.setCurrency(bankAccount.getCurrency() );

        return BankMapper.fromBank(bankRepository.save(account));
    }

    @Override
    public void delete(String id) {
        bankRepository.deleteById(id);
    }
}
