package com.mftplus.jee03practice.model.service;


import com.mftplus.jee03practice.model.entity.Transaction;
import com.mftplus.jee03practice.model.repository.CrudRepository;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

public class TransactionService implements Service<Transaction, Long> {
    @Getter
    private static TransactionService transactionService = new TransactionService();

    private TransactionService() {
    }

    @Override
    public void save(Transaction transaction) throws Exception {
        try (CrudRepository<Transaction, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.save(transaction);

        }
    }

    @Override
    public void edit(Transaction transaction) throws Exception {
        try (CrudRepository<Transaction, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.edit(transaction);
        }
    }

    @Override
    public void remove(Long id) throws Exception {
        try (CrudRepository<Transaction, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.remove(id, Transaction.class);
        }
    }

    @Override
    public Transaction findById(Long id) throws Exception {
        try (CrudRepository<Transaction, Long> crudRepository = new CrudRepository<>()) {
            return crudRepository.findById(id, Transaction.class);

        }
    }

    @Override
    public List<Transaction> findAll() throws Exception {
        try (CrudRepository<Transaction, Long> crudRepository = new CrudRepository<>()) {
            return crudRepository.findAll(Transaction.class);
        }
    }

    public Transaction findByTransactionDate(LocalDate transactionDate) throws Exception {
        try (CrudRepository<Transaction, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("transactionDate", transactionDate);
            List<Transaction> transactions = crudRepository.findBy("Transaction.findByTransactionDate", params, Transaction.class);
            return (transactions.isEmpty()) ? null : transactions.get(0);
        }
    }

    public Transaction findByTransactionTime(LocalTime transactionTime) throws Exception {
        try (CrudRepository<Transaction, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("transactionTime", transactionTime);
            List<Transaction> transactions = crudRepository.findBy("Transaction.findByTransactionTime", params, Transaction.class);
            return (transactions.isEmpty()) ? null : transactions.get(0);
        }
    }

    public Transaction findByTransactionNumber(Long transactionNumber) throws Exception {
        try (CrudRepository<Transaction, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("transactionNumber", transactionNumber);
            List<Transaction> transactions = crudRepository.findBy("Transaction.findByTransactionNumber", params, Transaction.class);
            return (transactions.isEmpty()) ? null : transactions.get(0);
        }
    }

    public Transaction findByCusUserAndPass(String username, String password) throws Exception {
        try (CrudRepository<Transaction, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("username", username);
            params.put("password", password);
            List<Transaction> transactions = crudRepository.findBy("Transaction.findByCusUserAndPass", params, Transaction.class);
            if (transactions.isEmpty()) {
                return null;
            } else {
                return transactions.get(0);
            }
        }
    }

    public Transaction findByCusUsername(String username) throws Exception {
        try (CrudRepository<Transaction, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("username", username);
            List<Transaction> transactions = crudRepository.findBy("Transaction.findByCusUsername", params, Transaction.class);
            if (transactions.isEmpty()) {
                return null;
            } else {
                return transactions.get(0);
            }
        }
    }

    public Transaction findByCusNameAndFamily(String name, String family) throws Exception {
        try (CrudRepository<Transaction, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("name", name);
            params.put("family", family);
            List<Transaction> transactions = crudRepository.findBy("Transaction.findByCusNameAndFamily", params, Transaction.class);
            if (transactions.isEmpty()) {
                return null;
            } else {
                return transactions.get(0);
            }
        }
    }

    public Transaction findByPaymentId(Long id) throws Exception {
        try (CrudRepository<Transaction, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("payment", id);//todo->maybe payment insteadOf id!!
            List<Transaction> transactions = crudRepository.findBy("Transaction.findByPaymentId", params, Transaction.class);
            if (transactions.isEmpty()) {
                return null;
            } else {
                return transactions.get(0);
            }
        }
    }

    public Transaction findByReserveId(Long id) throws Exception {
        try (CrudRepository<Transaction, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("reservation", id);
            List<Transaction> transactions = crudRepository.findBy("Transaction.findByReserveId", params, Transaction.class);
            if (transactions.isEmpty()) {
                return null;
            } else {
                return transactions.get(0);
            }
        }
    }
}
