package com.psk.bankApp.bankApplication.repository;

import com.psk.bankApp.bankApplication.model.Person;
import com.psk.bankApp.bankApplication.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@org.springframework.stereotype.Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface TransferRepository extends JpaRepository<Transfer, Long> {

    @Query(value = "select * from transfer where sender = ?1 or receiver = ?1", nativeQuery = true)
    public List<Transfer> getAllForAccount(Long id);
}
