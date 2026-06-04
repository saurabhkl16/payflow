package com.example.PayFlow.service;

import com.example.PayFlow.entity.Transaction;
import com.example.PayFlow.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction sendMoney(Transaction transaction){
        return transactionRepository.save(transaction);
    }
}
