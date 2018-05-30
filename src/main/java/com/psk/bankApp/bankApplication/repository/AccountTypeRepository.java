package com.psk.bankApp.bankApplication.repository;

import com.psk.bankApp.bankApplication.model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@org.springframework.stereotype.Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

}


