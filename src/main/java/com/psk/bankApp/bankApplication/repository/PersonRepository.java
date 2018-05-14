package com.psk.bankApp.bankApplication.repository;

import com.psk.bankApp.bankApplication.model.Person;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface PersonRepository extends Repository <Person, Long> {

    List<Person> findAll();
    Optional<Person> findOnePersonById(Long id);
    Optional<Person> save(Person person);
}


