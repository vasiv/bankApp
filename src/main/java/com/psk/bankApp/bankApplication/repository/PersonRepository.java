package com.psk.bankApp.bankApplication.repository;

import com.psk.bankApp.bankApplication.model.Person;
import org.springframework.data.repository.Repository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface PersonRepository extends Repository <Person, Long> {

    Optional<Person> findOnePersonById(Long id);
    Optional<Person> save(Person person);
}


