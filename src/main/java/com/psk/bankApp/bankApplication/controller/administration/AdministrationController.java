package com.psk.bankApp.bankApplication.controller.administration;

import com.psk.bankApp.bankApplication.model.Person;
import com.psk.bankApp.bankApplication.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdministrationController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "users/{1}", method = RequestMethod.GET)
    public ResponseEntity<Person> getUser(@PathVariable Long id){
        return personRepository.findOnePersonById(id)
                .map(todo -> ResponseEntity.ok().body(todo))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Person> createUserAccount(@RequestBody Person person, HttpServletRequest request, HttpServletResponse response) {
        return personRepository.save(person)
                .map(todo -> ResponseEntity.ok().body(todo))
                .orElse(ResponseEntity.notFound().build());
    }

}
