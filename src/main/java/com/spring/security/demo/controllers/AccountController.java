package com.spring.security.demo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.demo.dto.AccountRequest;
import com.spring.security.demo.dto.GenericResponse;
import com.spring.security.demo.entities.Account;
import com.spring.security.demo.service.AccountService;

@RestController
@RequestMapping("/api/auth")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ModelMapper modelMapper;



    public ResponseEntity<GenericResponse<String>> AddAccount(@RequestBody AccountRequest accountRequest){
        GenericResponse<String> response = new GenericResponse<>();
        try {
            Account account = modelMapper.map(accountRequest, Account.class);
            accountService.register(account);
            response.setStatus(true);
            response.getMessage().add("succes");
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.getMessage().add(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        
        }
        
    }
    
}
