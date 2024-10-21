package com.mftplus.jee03practice.model.service;

import com.mftplus.jee03practice.model.entity.Reservation;
import com.mftplus.jee03practice.model.repository.CrudRepository;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class ReservationService implements Service<Reservation, Long> {
    @Getter
    private static ReservationService reservationService = new ReservationService();

    private ReservationService() {
    }

    @Override
    public void save(Reservation reservation) throws Exception {
        try (CrudRepository<Reservation, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.save(reservation);

        }
    }

    @Override
    public void edit(Reservation reservation) throws Exception {
        try (CrudRepository<Reservation, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.edit(reservation);
        }
    }

    @Override
    public void remove(Long id) throws Exception {
        try (CrudRepository<Reservation, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.remove(id, Reservation.class);
        }
    }

    @Override
    public Reservation findById(Long id) throws Exception {
        try (CrudRepository<Reservation, Long> crudRepository = new CrudRepository<>()) {
            return crudRepository.findById(id, Reservation.class);

        }
    }

    @Override
    public List<Reservation> findAll() throws Exception {
        try (CrudRepository<Reservation, Long> crudRepository = new CrudRepository<>()) {
            return crudRepository.findAll(Reservation.class);
        }
    }

    public Reservation findByDateTime(LocalDateTime reservationDateTime) throws Exception {
        try (CrudRepository<Reservation, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("reservationDateTime", reservationDateTime);
            List<Reservation> reservations = crudRepository.findBy("Reservation.findByDateTime", params, Reservation.class);
            return (reservations.isEmpty()) ? null : reservations.get(0);
        }
    }

    public Reservation findByCusUserAndPass(String username, String password) throws Exception {
        try (CrudRepository<Reservation, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("username", username);
            params.put("password", password);
            List<Reservation> reservations = crudRepository.findBy("Reservation.findByCusUserAndPass", params, Reservation.class);
            if (reservations.isEmpty()) {
                return null;
            } else {
                return reservations.get(0);
            }
        }
    }

    public Reservation findByRoomId(Long id) throws Exception {
        try (CrudRepository<Reservation, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("rooms", id);
            List<Reservation> reservations = crudRepository.findBy("Reservation.findByRoomId", params, Reservation.class);
            if (reservations.isEmpty()) {
                return null;
            } else {
                return reservations.get(0);
            }
        }
    }
}
