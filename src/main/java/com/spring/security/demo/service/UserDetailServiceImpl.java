package com.spring.security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.spring.security.demo.entities.Account;
import com.spring.security.demo.repo.AccountRepo;
import com.spring.security.demo.utils.AccountDetails;

@Component
public class UserDetailServiceImpl  implements UserDetailsService{

    @Autowired
    private AccountRepo accountRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Account account = accountRep.findByEmail(username);
       if (account == null) {
        throw new UsernameNotFoundException("user not found");
       }
       return new AccountDetails(account);

    }
    
}
