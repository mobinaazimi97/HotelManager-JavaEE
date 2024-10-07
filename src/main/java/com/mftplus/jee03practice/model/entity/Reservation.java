package com.mftplus.jee03practice.model.entity;

import com.google.gson.Gson;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity(name = "reservationEntity")
@Table(name = "reservation_tbl")
public class Reservation {
    @Id
    @SequenceGenerator(name = "reservationSeq", sequenceName = "reservation_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "reservationSeq")
    private Long id;

    @Column(name = "reservation_amount" , nullable = false)
    private String amount;

    @Column(name = "reservation_date")
    private LocalDate reservationDate;

    @OneToOne
    private Customer customer;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
