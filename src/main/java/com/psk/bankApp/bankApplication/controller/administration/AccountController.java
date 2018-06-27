package com.psk.bankApp.bankApplication.controller.administration;

import com.psk.bankApp.bankApplication.model.Account;
import com.psk.bankApp.bankApplication.model.AccountType;
import com.psk.bankApp.bankApplication.model.Person;
import com.psk.bankApp.bankApplication.model.Transfer;
import com.psk.bankApp.bankApplication.repository.AccountRepository;
import com.psk.bankApp.bankApplication.repository.AccountTypeRepository;
import com.psk.bankApp.bankApplication.repository.PersonRepository;
import com.psk.bankApp.bankApplication.repository.TransferRepository;
import com.psk.bankApp.bankApplication.service.AccountService;
import com.psk.bankApp.bankApplication.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "http://localhost:4200")
@EnableOAuth2Sso
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountTypeRepository accountTypeRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    SessionService sessionService;

    @Autowired
    AccountService accountService;

    @Autowired
    TransferRepository transferRepository;

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    List<Account> getUserAccounts(OAuth2Authentication authentication){
        String sessionUserEmail = sessionService.getSessionUserEmail(authentication);
        Optional<Person> person  =  personRepository.findById(sessionUserEmail);
        List<Account> userAccounts = accountRepository.findByOwner(person.get().getEmail());
        return userAccounts;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ResponseEntity<Account> getAccountById(OAuth2Authentication authentication, @PathVariable("id") long id){
        String sessionUserEmail = sessionService.getSessionUserEmail(authentication);
        Optional<Account> accountOptional = accountRepository.findById(id);
        Person person = personRepository.findById(sessionUserEmail).get();
        if (accountOptional.isPresent() && accountOptional.get().getOwner().equals(person)) {
            return new ResponseEntity<Account>(accountOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Account>(HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value = "history/{id}", method = RequestMethod.GET)
    List<Transfer> getAccountHistory(OAuth2Authentication authentication, @PathVariable("id") long id){
        List<Transfer> transfers = transferRepository.getAllForAccount(id);
        return transfers;
    }

    @RequestMapping(value = "inactive", method = RequestMethod.GET)
    List<Account> getInactiveAccounts(){
        List<Account> accounts = accountRepository.getInactiveAccounts();
        return accounts;
    }

    @RequestMapping(value = "activate/{id}", method = RequestMethod.GET)
    void activateAcccount(@PathVariable("id") long id){
        accountRepository.activateAcccount(id);
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    void create(OAuth2Authentication authentication){
        String sessionUserEmail = sessionService.getSessionUserEmail(authentication);
        Person creator  =  personRepository.findById(sessionUserEmail).get();
        Account account = accountService.create(creator);
        accountRepository.save(account);
    }
}
