package com.psk.bankApp.bankApplication.controller.administration;

import com.psk.bankApp.bankApplication.model.Person;
import com.psk.bankApp.bankApplication.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
@EnableOAuth2Sso
public class AdministrationController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    List<Person> getAllUsers(){
        List<Person> persons  =  personRepository.findAll();
        System.out.println(persons.toString());

        Person person =personRepository.findOnePersonById(1L).get();
        System.out.println("person: " + person.getFirstName());
        return persons;

    }
}
