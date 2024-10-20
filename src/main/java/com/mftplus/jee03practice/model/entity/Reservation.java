package com.mftplus.jee03practice.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
@Entity(name = "reservationEntity")
@Table(name = "reservation_tbl")
@NamedQueries({
        @NamedQuery(name = "Reservation.findByDateTime", query = "select re from reservationEntity re where re.reservationDateTime = : reservationDateTime"),
        @NamedQuery(name = "Reservation.findByCusTransNum", query = "select re from reservationEntity re where re.customer.cusTransaction.transactionNumber = : transactionNumber"),
        @NamedQuery(name = "Reservation.findByCusUserAndPass", query = "select re from reservationEntity re where re.customer.username = : username and re.customer.password=:password")


})

public class Reservation extends Base {
    @Id
    @SequenceGenerator(name = "reservationSeq", sequenceName = "reservation_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservationSeq")
    private Long id;

    @Column(name = "reservation_amount", nullable = false)
    private String amount;

    @Column(name = "reservation_dateTime")
    private LocalDate reservationDateTime;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Customer customer;

}
