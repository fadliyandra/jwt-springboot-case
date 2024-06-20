package com.spring.security.demo.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.spring.security.demo.entities.AccountRole;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest {
     

    private String fullName;

    private String email;

    private String password;

 
    private Set<AccountRole> roles = new HashSet<>();
    
}
