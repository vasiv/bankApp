package com.psk.bankApp.bankApplication.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer id;

    @NotNull
    private String country;

    @NotNull
    private String city;

    @NotNull
    private String street;

    @Column(name = "house_number")
    @NotNull
    private String houseNumber;

    @Column(name = "place_number")
    private String placeNumber;

    @NotNull
    private String postcode;
}
