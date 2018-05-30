package com.psk.bankApp.bankApplication.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Person {

    @Id
    @NotNull
    private String email;

    @Column(name = "first_name")
    @NotNull
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "last_name")
    @NotNull
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "address")
    @NotNull
    private Address address;

    @Column(name = "personal_identity_number", unique = true)
    @NotNull
    private String personalIdentityNumber;

    @Column(name = "is_active")
    @NotNull
    private boolean isActive;
}
