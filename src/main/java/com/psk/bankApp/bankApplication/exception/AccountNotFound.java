package com.psk.bankApp.bankApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AccountNotFound extends RuntimeException {

    private static final long serialVersionUID = -8860031929489837481L;

    private String accountNumber;

    public AccountNotFound(String accountNumber) {
        super(String.format("Not found account with number %s'", accountNumber));
        this.setAccountNumber(accountNumber);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}

