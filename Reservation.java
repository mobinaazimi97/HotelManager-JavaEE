package com.mftplus.jee03practice.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
@Entity(name = "reservationEntity")
@Table(name = "reservation_tbl")
@NamedQueries({
        @NamedQuery(name = "Reservation.findByDate", query = "select re from reservationEntity re where re.reservationDate = : reservationDate"),
        @NamedQuery(name = "Reservation.findByTime", query = "select re from reservationEntity re where re.reservationTime = : reservationTime"),
        @NamedQuery(name = "Reservation.findByCusTransNum", query = "select re from reservationEntity re where re.customer.cusTransaction.transactionNumber = : transactionNumber"),
        @NamedQuery(name = "Reservation.findByCusUserAndPass", query = "select re from reservationEntity re where re.customer.username = : username and re.customer.password=:password"),
        @NamedQuery(name = "Reservation.findByRoomId", query = "select re from reservationEntity re where re.rooms.id = : rooms ")
})

public class Reservation extends Base {
    @Id
    @SequenceGenerator(name = "reservationSeq", sequenceName = "reservation_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservationSeq")
    private Long id;

    @Column(name = "reservation_amount", nullable = false)
    private String amount;

    @Column(name = "reservation_date")
    private LocalDate reservationDate;

    @Column(name = "reservation_time")
    private LocalTime reservationTime;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Customer customer;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)//todo input uml this
    private Rooms rooms;


}
