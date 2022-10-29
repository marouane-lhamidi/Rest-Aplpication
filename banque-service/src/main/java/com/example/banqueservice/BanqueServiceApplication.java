package com.example.banqueservice;

import com.example.banqueservice.entities.BankAccount;
import com.example.banqueservice.entities.Customer;
import com.example.banqueservice.enums.AccountType;
import com.example.banqueservice.repositories.BankRepository;
import com.example.banqueservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BanqueServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BanqueServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BankRepository bankRepository, CustomerRepository customerRepository){
        return args -> {
            Stream.of("Maroune", "Hamza", "salma", "Soufiane").forEach(c -> {
                        Customer customer = Customer.builder().name(c).build();
                        customerRepository.save(customer);
                    });
            customerRepository.findAll().forEach(customer -> {
                for (int i=0; i<10; i++){
                    BankAccount bankAccount = BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .balance(1000 + Math.random()*10001)
                            .type(Math.random()>0.5? AccountType.SAVING_ACCOUNT : AccountType.CURRENT_ACCOUNT)
                            .createdAt(new Date())
                            .currency("MAD")
                            .customer(customer)
                            .build();
                    bankRepository.save(bankAccount);
                }
            });

        };
    }

}
