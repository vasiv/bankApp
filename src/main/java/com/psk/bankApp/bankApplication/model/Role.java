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
public class Role {

    @Id
    @NotNull
    @Column(name = "role_id")
    private Long id;

    @NotNull
    private String role;

}
