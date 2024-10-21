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
        @NamedQuery(name = "Room.findByRoomNum", query = "select rr from roomEntity rr where rr.roomNumber =: roomNumber"),
        @NamedQuery(name = "Room.findByReserveDate", query = "select rr from roomEntity rr where rr.reservation.reservationDate =: reservationDate"),
        @NamedQuery(name = "Room.findByReserveTime", query = "select rr from roomEntity rr where rr.reservation.reservationTime =: reservationTime"),
        @NamedQuery(name = "Room.findByReserveId", query = "select rr from roomEntity rr where rr.reservation.id =: reservation"),
        @NamedQuery(name = "Room.findByCusUsername", query = "select rr from roomEntity rr where rr.reservation.customer.username =: customer")
  //todo      @NamedQuery(name = "Room.findByCusUserAndPass", query = "select rr from roomEntity rr where rr.reservation.customer.username =: customer and  rr.reservation.customer.password=:password")
})

public class Rooms extends Base {
    @Id
    @SequenceGenerator(name = "roomSeq", sequenceName = "room_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roomSeq")
    private Long id;

    @Column(name = "detail", length = 50)
    private String detail;

    @Column(name = "requirement", length = 60)
    private String requirement;

    @Column(name = "roomNumber",length = 50)
    private String roomNumber;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Reservation reservation;

//    @OneToMany(mappedBy ="roomEmployee" , cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//    private List<Employee> employees = new ArrayList<>();
}
