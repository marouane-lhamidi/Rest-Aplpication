package com.example.banqueservice.repositories;

import com.example.banqueservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<BankAccount, String> {
}
