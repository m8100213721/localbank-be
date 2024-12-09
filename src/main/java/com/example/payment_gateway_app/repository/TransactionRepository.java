package com.example.payment_gateway_app.repository;

import com.example.payment_gateway_app.entity.Transaction;
import com.example.payment_gateway_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findTrasactionByUserId(Long userId);
    List<Transaction> findTrasactionByAccountId(Long accountId);
}