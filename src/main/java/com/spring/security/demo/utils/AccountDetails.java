package com.spring.security.demo.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.spring.security.demo.entities.Account;
import com.spring.security.demo.entities.AccountRole;

public class AccountDetails extends Account implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public AccountDetails(Account account) {
        this.username = account.getEmail();
        this.password = account.getPassword();
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (AccountRole role : account.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
        }
        this.authorities = authorities;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
    
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
