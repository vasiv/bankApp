package com.psk.bankApp.bankApplication.service;

import com.psk.bankApp.bankApplication.model.Person;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.Optional;

public interface SessionService {

//    Optional<Person> findLoggedUser(OAuth2Authentication authentication);
        String getSessionUserEmail(OAuth2Authentication authentication);
}
