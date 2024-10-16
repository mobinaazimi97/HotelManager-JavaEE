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
        @NamedQuery(name = "Reservation.findByDate", query = "select re from reservationEntity re where re.reservationDate = : reservationDate")
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

    @OneToOne(cascade = CascadeType.PERSIST , fetch = FetchType.EAGER)
    private Customer customer;

//    @Override
//    public String toString() {
//        return new Gson().toJson(this);
//    }
}
