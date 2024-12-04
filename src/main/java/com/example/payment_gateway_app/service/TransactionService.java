package com.example.payment_gateway_app.service;

import com.example.payment_gateway_app.entity.Transaction;

import java.util.List;

public interface TransactionService {
    public List<Transaction> getAllTransactions();

    public Transaction saveTransaction(Transaction transaction);

    public Transaction getTransactionById(Long id);

    public void deleteTransactionById(Long id);

    public List<Transaction> getTransactionsByUserId(Long userId);

}