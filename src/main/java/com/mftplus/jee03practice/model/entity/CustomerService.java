package com.mftplus.jee03practice.model.service;

import com.mftplus.jee03practice.model.entity.Customer;
import com.mftplus.jee03practice.model.repository.CrudRepository;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

public class CustomerService implements Service<Customer, Long> {
    @Getter
    private static CustomerService customerService = new CustomerService();

    private CustomerService() {
    }

    @Override
    public void save(Customer customer) throws Exception {
        try (CrudRepository<Customer, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.save(customer);

        }
    }

    @Override
    public void edit(Customer customer) throws Exception {
        try (CrudRepository<Customer, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.edit(customer);
        }
    }

    @Override
    public void remove(Long id) throws Exception {
        try (CrudRepository<Customer, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.remove(id, Customer.class);
        }
    }

    @Override
    public Customer findById(Long id) throws Exception {
        try (CrudRepository<Customer, Long> crudRepository = new CrudRepository<>()) {
            return crudRepository.findById(id, Customer.class);

        }
    }

    @Override
    public List<Customer> findAll() throws Exception {
        try (CrudRepository<Customer, Long> crudRepository = new CrudRepository<>()) {
            return crudRepository.findAll(Customer.class);
        }
    }


    public List<Customer> findByFamily(String family) throws Exception {
        try (CrudRepository<Customer, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("family", family);
            return crudRepository.findBy("Customer.findByFamily", params, Customer.class);
        }
    }

    public Customer findByUsernameAndPassword(String username, String password) throws Exception {
        try (CrudRepository<Customer, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("username", username);
            params.put("password", password);
            List<Customer> customers = crudRepository.findBy("Customer.findByUsernameAndPassword", params, Customer.class);
            return (customers.isEmpty()) ? null : customers.get(0);
        }
    }

    public Customer findByTransactionDate(LocalDate transactionDate) throws Exception {
        try (CrudRepository<Customer, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("transactionDate", transactionDate);
            List<Customer> customers = crudRepository.findBy("Customer.findByTransactionDate", params, Customer.class);
            if (customers.isEmpty()) {
                return null;
            } else {
                return customers.get(0);
            }
        }
    }

    public Customer findByTransactionTime(LocalTime transactionTime) throws Exception {
        try (CrudRepository<Customer, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("transactionTime", transactionTime);
            List<Customer> customers = crudRepository.findBy("Customer.findByTransactionTime", params, Customer.class);
            if (customers.isEmpty()) {
                return null;
            } else {
                return customers.get(0);
            }
        }
    }

    public Customer findByTransactionNum(Long transactionNumber) throws Exception {
        try (CrudRepository<Customer, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("transactionNumber", transactionNumber);
            List<Customer> customers = crudRepository.findBy("Customer.findByTransactionNum", params, Customer.class);
            if (customers.isEmpty()) {
                return null;
            } else {
                return customers.get(0);
            }
        }
    }
}
