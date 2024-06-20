package com.spring.security.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.security.demo.entities.AccountRole;

public interface AccountRoleRepo extends JpaRepository<AccountRole, Long>{
    AccountRole findByName(String name);
    
}
