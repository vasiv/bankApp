package com.psk.bankApp.bankApplication.repository;

import com.psk.bankApp.bankApplication.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@org.springframework.stereotype.Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "select * from account where owner =?1", nativeQuery = true)
    List<Account> findByOwner(String email);

    @Query(value = "select * from account where number =?1", nativeQuery = true)
    Account findByAccountNumber(String number);

    @Modifying
    @Transactional
    @Query(value = "update account set funds = ?1 where account_id = ?2", nativeQuery = true)
    void updateFunds(Double funds, Long id);
}


