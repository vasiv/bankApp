package com.psk.bankApp.bankApplication.controller.administration;

import com.psk.bankApp.bankApplication.model.Transfer;
import com.psk.bankApp.bankApplication.model.TransferDTO;
import com.psk.bankApp.bankApplication.repository.TransferRepository;
import com.psk.bankApp.bankApplication.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/transfer/perform")
@CrossOrigin(origins = "http://localhost:4200")
@EnableOAuth2Sso
public class TransferController {

    @Autowired
    TransferRepository transferRepository;

    @Autowired
    TransferService transferService;

    @PostMapping()
    ResponseEntity<?> performTransfer(@RequestBody TransferDTO transferDto) {
        Transfer transfer = transferService.performTransfer(transferDto);
        transferRepository.save(transfer);
        System.out.println(transfer);
        return null;
    }
}

