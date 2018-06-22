package com.psk.bankApp.bankApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "people_with_roles",
            joinColumns = { @JoinColumn(name = "person_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") })
    private Set<Role> roles = new HashSet<>();
}
