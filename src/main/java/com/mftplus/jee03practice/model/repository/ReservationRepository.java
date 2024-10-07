package com.mftplus.jee03practice.model.repository;

import com.mftplus.jee03practice.model.entity.Reservation;
import com.mftplus.jee03practice.model.utils.JpaProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ReservationRepository implements AutoCloseable {


    private EntityManager entityManager;

    public void save(Reservation reservation) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(reservation);
        transaction.commit();
    }

    public void edit(Reservation reservation) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(reservation);
        transaction.commit();
    }

    public void remove(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Reservation reservation = entityManager.find(Reservation.class, id);
        entityManager.remove(reservation);
        transaction.commit();
    }

    public Reservation findById(Long id) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        return entityManager.find(Reservation.class, id);
    }

    @Override
    public void close() throws Exception {
        entityManager.close();

    }
}
