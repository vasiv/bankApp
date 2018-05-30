package com.psk.bankApp.bankApplication.repository;

import com.psk.bankApp.bankApplication.model.Account;
import com.psk.bankApp.bankApplication.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@org.springframework.stereotype.Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "select * from account where owner =?1", nativeQuery = true)
    List<Account> findByOwner(String email);

}


