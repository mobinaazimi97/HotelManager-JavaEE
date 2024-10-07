package com.mftplus.jee03practice.model.repository;

import com.mftplus.jee03practice.model.entity.Employee;
import com.mftplus.jee03practice.model.utils.JpaProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EmployeeRepository implements AutoCloseable {


    private EntityManager entityManager;

    public void save(Employee employee) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee);
        transaction.commit();
    }

    public void edit(Employee employee) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(employee);
        transaction.commit();
    }

    public void remove(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
        transaction.commit();
    }

    public Employee findById(Long id) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        return entityManager.find(Employee.class, id);
    }


    @Override
    public void close() throws Exception {
        entityManager.close();

    }
}
