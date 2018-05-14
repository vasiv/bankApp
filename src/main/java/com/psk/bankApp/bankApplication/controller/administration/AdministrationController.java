package com.psk.bankApp.bankApplication.controller.administration;

import com.psk.bankApp.bankApplication.model.Person;
import com.psk.bankApp.bankApplication.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class AdministrationController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping(value = "/all")
    List<Person> getAllUsers(){
        List<Person> persons  =  personRepository.findAll();
        System.out.println(persons.toString());

        Person person =personRepository.findOnePersonById(1L).get();
        System.out.println("person: " + person.getFirstName());
        return persons;

    }
}
