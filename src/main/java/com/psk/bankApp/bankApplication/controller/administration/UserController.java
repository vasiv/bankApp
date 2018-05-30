package com.psk.bankApp.bankApplication.controller.administration;

import com.psk.bankApp.bankApplication.model.Person;
import com.psk.bankApp.bankApplication.repository.PersonRepository;
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
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
@EnableOAuth2Sso
public class UserController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    SessionService sessionService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    List<Person> getAllUsers(){
        List<Person> persons  =  personRepository.findAll();
        return persons;
    }

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    ResponseEntity<Person> getLoggedUser(OAuth2Authentication authentication){
        String sessionUserEmail = sessionService.getSessionUserEmail(authentication);
        Optional<Person> optionalPerson =  personRepository.findById(sessionUserEmail);
        if (optionalPerson.isPresent()) {
            return new ResponseEntity<Person>(optionalPerson.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
    }
}
