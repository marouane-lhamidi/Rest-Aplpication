package com.example.banqueservice.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity @Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "customer")
    private List<BankAccount> accounts;
}
