package com.pdk.bankApp.bankApplication.repository;

import com.pdk.bankApp.bankApplication.model.Person;
import org.springframework.data.repository.Repository;

public interface PersonRepository extends Repository <Person, Long> {

    Person findOnePersonById(Long id);
}
