package com.psk.bankApp.bankApplication.service;

import com.psk.bankApp.bankApplication.model.Account;
import com.psk.bankApp.bankApplication.model.Person;
import com.psk.bankApp.bankApplication.repository.AccountRepository;
import com.psk.bankApp.bankApplication.repository.AccountTypeRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountTypeRepository accountTypeRepository;

    @Override
    public Account create(Person owner) {
        boolean numberInUse = true;
        String generatedNumber = "";
        while(numberInUse){
            generatedNumber = RandomStringUtils.random(26, false, true);
            numberInUse = isNumberInUse(generatedNumber);
        }
        return new Account(generatedNumber, accountTypeRepository.getOne(1L), owner);
    }

    private boolean isNumberInUse(String generatedNumber){
        Account account = accountRepository.findByAccountNumber(generatedNumber);
        if (account == null)
            return false;
        return true;
    }

}
