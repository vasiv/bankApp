package com.psk.bankApp.bankApplication.service;

import com.psk.bankApp.bankApplication.model.Person;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class SessionServiceImpl implements SessionService {

    public String getSessionUserEmail(OAuth2Authentication authentication) {
        Authentication userAuthentication = authentication.getUserAuthentication();
        Map details = (Map) userAuthentication.getDetails();
        return (String) details.get("email");
    }

}
