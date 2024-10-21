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
@Entity(name = "paymentEntity")
@Table(name = "payment_tbl")
@NamedQueries({
        @NamedQuery(name = "Payment.findByPayType", query = "select pp from paymentEntity pp where pp.payType like : payType"),
        @NamedQuery(name = "Payment.cusUserAndPass", query = "select pp from paymentEntity pp where pp.customer.username = : username and pp.customer.password = : password"),
        @NamedQuery(name = "Payment.cusEmail", query = "select pp from paymentEntity pp where pp.customer.email = : email"),
        @NamedQuery(name = "Payment.findByCusTransNumber", query = "select pp from paymentEntity pp where pp.customer.cusTransaction.transactionNumber =:transactionNumber "),
        @NamedQuery(name = "Payment.findByRoomNumber", query = "select pp from paymentEntity pp where pp.rooms.roomNumber = : roomNumber")
})

public class Payment extends Base {
    @Id
    @SequenceGenerator(name = "paymentSeq", sequenceName = "payment_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paymentSeq")
    private Long id;

    @Column(name = "payment_type", length = 20, nullable = false)
    private String payType;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Customer customer;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Rooms rooms;


}
