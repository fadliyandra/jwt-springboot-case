package com.spring.security.demo.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.security.demo.entities.Account;

public interface AccountRepo  extends JpaRepository<Account, UUID>{
    Account findByEmail(String email);
    
}
