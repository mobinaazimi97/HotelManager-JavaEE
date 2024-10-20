package com.mftplus.jee03practice.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
@Entity(name = "roomEntity")
@Table(name = "room_tbl")
@NamedQueries({
        @NamedQuery(name = "Room.findByRequirement", query = "select rr from roomEntity rr where rr.requirement like : requirement"),
        @NamedQuery(name = "Room.findByReserveDateTime", query = "select rr from roomEntity rr where rr.reservation.reservationDateTime =: reservationDateTime"),
        @NamedQuery(name = "Room.findByReserveId", query = "select rr from roomEntity rr where rr.reservation.id =: id"),
        @NamedQuery(name = "Room.findByCusUsername", query = "select rr from roomEntity rr where rr.reservation.customer.username =: username")
})

public class Rooms extends Base {
    @Id
    @SequenceGenerator(name = "roomSeq", sequenceName = "room_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roomSeq")
    private Long id;

    @Column(name = "detail", length = 60, columnDefinition = "Nvarchar2()")
    private String detail;

    @Column(name = "requirement", length = 60)
    private String requirement;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Reservation reservation;

}
