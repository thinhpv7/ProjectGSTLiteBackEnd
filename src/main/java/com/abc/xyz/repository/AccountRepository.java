package com.abc.xyz.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.xyz.entity.Account;

 
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByAccountname(String accountname);
    Boolean existsByAccountname(String accountname);
    Boolean existsByEmail(String email);
}