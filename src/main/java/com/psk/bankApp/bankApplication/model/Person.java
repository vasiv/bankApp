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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;

    @Column(unique = true)
    @NotNull
    private String login;

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

    @NotNull
    private String email;

    @Column(name = "is_active")
    @NotNull
    private boolean isActive;
}
