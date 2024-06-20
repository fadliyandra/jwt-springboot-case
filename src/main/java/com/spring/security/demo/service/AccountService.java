package com.spring.security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.security.demo.entities.Account;
import com.spring.security.demo.repo.AccountRepo;
import com.spring.security.demo.repo.AccountRoleRepo;

@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private AccountRoleRepo accountRoleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Account geAccountByEmail(String email){
        return accountRepo.findByEmail(email);
    }

    public String register (Account account){
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        if (account.getRoles().isEmpty()) {
            account.getRoles().add(accountRoleRepo.findByName("ROLE_USER"));
            
        }
        accountRepo.save(account);
        return "account create succes";


    }

    

    
}
