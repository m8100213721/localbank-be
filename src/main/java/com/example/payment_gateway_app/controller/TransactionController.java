package com.example.payment_gateway_app.controller;

import com.example.payment_gateway_app.entity.Transaction;
import com.example.payment_gateway_app.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/process")
    public ResponseEntity<Transaction> processTransaction(@RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionService.saveTransaction(transaction));
    }

    @GetMapping("/history")
    public ResponseEntity<List<Transaction>> getTransactionHistory(@RequestParam Long userId) {
        return ResponseEntity.ok(transactionService.getTransactionsByUserId(userId));
    }
}