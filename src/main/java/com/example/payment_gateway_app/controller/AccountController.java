package com.example.payment_gateway_app.controller;

import com.example.payment_gateway_app.entity.Account;
import com.example.payment_gateway_app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.saveAccount(account));
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAccountDetails(@RequestParam Long accountId) {
        return ResponseEntity.ok(Collections.singletonList(accountService.getAccountById(accountId)));
    }
}
