package com.mftplus.jee03practice.model.service;
import com.mftplus.jee03practice.model.entity.Customer;
import com.mftplus.jee03practice.model.repository.CustomerRepository;

public class CustomerService {

    public static void save(Customer customer) throws Exception {

        try (CustomerRepository customerRepository = new CustomerRepository()) {
            customerRepository.save(customer);
        }
    }

    public static void edit(Customer customer) throws Exception {

        try (CustomerRepository customerRepository = new CustomerRepository()) {
            customerRepository.edit(customer);
        }
    }
}
