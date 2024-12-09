package com.example.payment_gateway_app.service;

import com.example.payment_gateway_app.entity.Account;
import com.example.payment_gateway_app.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    // Update Account
    //@Transactional
    @Override
    public Account updateAccount(Long id, Account accountDetails) {
        Account account = getAccountById(id);
        account.setAccountNumber(accountDetails.getAccountNumber());
        account.setBalance(accountDetails.getBalance());
        account.setAccountType(accountDetails.getAccountType());
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAccountById(Long id) {
        accountRepository.deleteById(id);
    }
}
