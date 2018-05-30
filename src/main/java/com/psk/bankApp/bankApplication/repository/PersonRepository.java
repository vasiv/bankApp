package com.psk.bankApp.bankApplication.repository;

import com.psk.bankApp.bankApplication.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@org.springframework.stereotype.Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface PersonRepository extends JpaRepository<Person, String> {

}


