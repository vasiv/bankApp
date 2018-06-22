package com.psk.bankApp.bankApplication.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TransferDTO {

    private String receiver;
    private String sender;
    private String transferAmount;
    private String description;
    private boolean isPeriodic;
}
