package com.mftplus.jee03practice.model.repository;

import com.mftplus.jee03practice.model.entity.Admin;
import com.mftplus.jee03practice.model.utils.JpaProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class AdminRepository implements AutoCloseable {

    private EntityManager entityManager;

    public void save(Admin admin) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(admin);
        transaction.commit();
    }

    public void edit(Admin admin) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(admin);
        transaction.commit();
    }

    public void remove(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Admin admin = entityManager.find(Admin.class, id);
        entityManager.remove(admin);
        transaction.commit();
    }

    public Admin findById(Long id) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        return entityManager.find(Admin.class, id);
    }

    @Override
    public void close() throws Exception {
        entityManager.close();

    }
}
