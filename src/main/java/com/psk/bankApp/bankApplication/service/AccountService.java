package com.psk.bankApp.bankApplication.service;

import com.psk.bankApp.bankApplication.model.Account;
import com.psk.bankApp.bankApplication.model.Person;

public interface AccountService {

    Account create(Person owner);
}
