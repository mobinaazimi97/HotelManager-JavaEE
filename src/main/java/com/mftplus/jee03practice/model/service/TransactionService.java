package com.mftplus.jee03practice.model.service;

import com.mftplus.jee03practice.model.entity.Transaction;
import com.mftplus.jee03practice.model.repository.TransactionRepository;

public class TransactionService {

    public static void save(Transaction transaction) throws Exception {

        try (TransactionRepository transactionRepository = new TransactionRepository()) {
            transactionRepository.save(transaction);
        }
    }

    public static void edit(Transaction transaction) throws Exception {

        try (TransactionRepository transactionRepository = new TransactionRepository()) {
            transactionRepository.edit(transaction);
        }
    }
}
