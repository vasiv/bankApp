package com.psk.bankApp.bankApplication.service;

import com.psk.bankApp.bankApplication.model.Transfer;
import com.psk.bankApp.bankApplication.model.TransferDTO;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

public interface TransferService {

    Transfer performTransfer(TransferDTO transferDTO);
}
