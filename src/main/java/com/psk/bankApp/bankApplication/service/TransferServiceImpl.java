package com.psk.bankApp.bankApplication.service;

import com.psk.bankApp.bankApplication.model.Account;
import com.psk.bankApp.bankApplication.model.Person;
import com.psk.bankApp.bankApplication.model.Transfer;
import com.psk.bankApp.bankApplication.model.TransferDTO;
import com.psk.bankApp.bankApplication.repository.AccountRepository;

import com.psk.bankApp.bankApplication.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    SessionService sessionService;

    @Override
    public Transfer performTransfer(TransferDTO transferDTO) {
        Account sender = accountRepository.findById(Long.parseLong(transferDTO.getSender())).get();
        Account receiver = accountRepository.findByAccountNumber(transferDTO.getReceiver());
        Double transferAmount = Double.parseDouble(transferDTO.getTransferAmount());
        if(sender.getFunds() < transferAmount)
            System.out.println("Za duzo przelewasz ziomek");
        Double senderFunds = sender.getFunds();
        Double receiverFunds = receiver.getFunds();
        senderFunds -= transferAmount;
        receiverFunds += transferAmount;
        sender.setFunds(senderFunds);
        receiver.setFunds(receiverFunds);
        accountRepository.updateFunds(senderFunds, sender.getId());
        accountRepository.updateFunds(receiverFunds, receiver.getId());
        Date date = new Date(System.currentTimeMillis());
        return new Transfer(sender, receiver, date, transferAmount, transferDTO.getDescription(), false);
    }
}
