package com.mftplus.jee03practice.model.repository;

import com.mftplus.jee03practice.model.entity.Customer;
import com.mftplus.jee03practice.model.utils.JpaProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CustomerRepository implements AutoCloseable {


    private EntityManager entityManager;

    public void save(Customer customer) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(customer);
        transaction.commit();
    }

    public void edit(Customer customer) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(customer);
        transaction.commit();
    }

    public void remove(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customer = entityManager.find(Customer.class, id);
        entityManager.remove(customer);
        transaction.commit();
    }

    public Customer findById(Long id) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        return entityManager.find(Customer.class, id);
    }


    @Override
    public void close() throws Exception {
        entityManager.close();

    }
}
