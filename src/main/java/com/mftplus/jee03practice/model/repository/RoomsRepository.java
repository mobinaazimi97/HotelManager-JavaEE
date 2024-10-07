package com.mftplus.jee03practice.model.repository;

import com.mftplus.jee03practice.model.entity.Rooms;
import com.mftplus.jee03practice.model.utils.JpaProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class RoomsRepository implements AutoCloseable {
    private EntityManager entityManager;

    public void save(Rooms rooms) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(rooms);
        transaction.commit();
    }

    public void edit(Rooms rooms) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(rooms);
        transaction.commit();
    }

    public void remove(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Rooms rooms = entityManager.find(Rooms.class, id);
        entityManager.remove(rooms);
        transaction.commit();
    }

    public Rooms findById(Long id) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        return entityManager.find(Rooms.class, id);
    }


    @Override
    public void close() throws Exception {
        entityManager.close();
    }
}
