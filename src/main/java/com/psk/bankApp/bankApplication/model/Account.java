package com.psk.bankApp.bankApplication.model;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Account {

    public Account(String number, AccountType accountType, Person owner){
        this.number = number;
        this.accountType = accountType;
        this.owner = owner;
        funds = 0.0;
        isActive = false;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @NotNull
    @Column (unique = true)
    private String number;

    private Double funds;

    @ManyToOne
    @JoinColumn(name = "account_type")
    @NotNull
    private AccountType accountType;

    @ManyToOne
    @JoinColumn(name = "owner")
    @NotNull
    private Person owner;

    @Column(name = "is_active")
    private boolean isActive;
}
