package com.mftplus.jee03practice.model.service;


import com.mftplus.jee03practice.model.entity.Reservation;
import com.mftplus.jee03practice.model.repository.ReservationRepository;

public class ReservationService {

    public static void save(Reservation reservation) throws Exception {

        try (ReservationRepository reservationRepository = new ReservationRepository()) {
            reservationRepository.save(reservation);
        }
    }

    public static void edit(Reservation reservation) throws Exception {

        try (ReservationRepository reservationRepository = new ReservationRepository()) {
            reservationRepository.edit(reservation);
        }
    }
}
