package com.mftplus.jee03practice.model.repository;

import com.mftplus.jee03practice.model.entity.Transaction;
import com.mftplus.jee03practice.model.utils.JpaProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class TransactionRepository implements AutoCloseable {


    private EntityManager entityManager;

    public void save(Transaction ttransaction) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(ttransaction);
        transaction.commit();
    }

    public void edit(Transaction ttransaction) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(ttransaction);
        transaction.commit();
    }

    public void remove(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Transaction ttransaction = entityManager.find(Transaction.class, id);
        entityManager.remove(ttransaction);
        transaction.commit();
    }

    public Transaction findById(Long id) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        return entityManager.find(Transaction.class, id);
    }

    @Override
    public void close() throws Exception {
        entityManager.close();

    }
}
