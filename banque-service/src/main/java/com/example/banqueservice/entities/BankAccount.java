package com.example.banqueservice.entities;

import com.example.banqueservice.enums.AccountType;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccount {
    @Id
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @ManyToOne
    private Customer customer;

}
