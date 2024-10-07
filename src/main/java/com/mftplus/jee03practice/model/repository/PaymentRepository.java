package com.mftplus.jee03practice.model.repository;

import com.mftplus.jee03practice.model.entity.Payment;
import com.mftplus.jee03practice.model.utils.JpaProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PaymentRepository implements AutoCloseable {

    private EntityManager entityManager;

    public void save(Payment payment) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(payment);
        transaction.commit();
    }

    public void edit(Payment payment) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(payment);
        transaction.commit();
    }

    public void remove(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Payment payment = entityManager.find(Payment.class, id);
        entityManager.remove(payment);
        transaction.commit();
    }

    public Payment findById(Long id) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        return entityManager.find(Payment.class, id);
    }


    @Override
    public void close() throws Exception {
        entityManager.close();

    }
}
