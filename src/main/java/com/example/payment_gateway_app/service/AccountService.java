package com.example.payment_gateway_app.service;

import com.example.payment_gateway_app.entity.Account;

import java.util.List;

public interface AccountService {
    public List<Account> getAllAccounts();

    public Account saveAccount(Account account);

    public Account getAccountById(Long id);

    public void deleteAccountById(Long id);
}