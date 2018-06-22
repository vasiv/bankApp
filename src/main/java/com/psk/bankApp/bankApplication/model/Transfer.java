package com.psk.bankApp.bankApplication.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transfer_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender")
    @NotNull
    private Account sender;

    @ManyToOne
    @JoinColumn(name = "receiver")
    @NotNull
    private Account receiver;

    @NotNull
    private Date date;

    @Column(name = "transfer_amount")
    @NotNull
    private Double transferAmount;

    @NotNull
    private String description;

    @Column(name = "is_periodic")
    @NotNull
    private boolean isPeriodic;

    public Transfer(@NotNull Account sender, @NotNull Account receiver, @NotNull Date date, @NotNull Double transferAmount,
                    @NotNull String description, @NotNull boolean isPeriodic) {
        this.sender = sender;
        this.receiver = receiver;
        this.date = date;
        this.transferAmount = transferAmount;
        this.description = description;
        this.isPeriodic = isPeriodic;
    }
}
