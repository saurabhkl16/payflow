package com.example.PayFlow.controller;

import com.example.PayFlow.entity.Transaction;
import com.example.PayFlow.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transactions")
    public Transaction sendMoney(Transaction transaction){
        return transactionService.sendMoney(transaction);
    }
}
