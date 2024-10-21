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
@Entity(name = "transactionEntity")
@Table(name = "transactions_tbl")
@NamedQueries({
        @NamedQuery(name = "Transaction.findByTransactionDate", query = "select tt from transactionEntity tt where tt.transactionDate = : transactionDate"),
        @NamedQuery(name = "Transaction.findByTransactionTime", query = "select tt from transactionEntity tt where tt.transactionTime = : transactionTime"),
        @NamedQuery(name = "Transaction.findByTransactionNumber", query = "select tt from transactionEntity tt where tt.transactionNumber =:transactionNumber"),
        @NamedQuery(name = "Transaction.findByCusUserAndPass", query = "select tt from transactionEntity tt where tt.customer.username =:username and tt.customer.password = : password"),
        @NamedQuery(name = "Transaction.findByCusUsername", query = "select tt from transactionEntity tt where tt.customer.username =:username"),
        @NamedQuery(name = "Transaction.findByCusNameAndFamily", query = "select tt from transactionEntity tt where tt.customer.name = :name and tt.customer.family = : family"),
        @NamedQuery(name = "Transaction.findByPaymentId", query = "select tt from transactionEntity tt where tt.payment.id = : payment"),
        @NamedQuery(name = "Transaction.findByReserveId", query = "select tt from transactionEntity tt where tt.reservation.id = : reservation")
})

public class Transaction extends Base {
    @Id
    @SequenceGenerator(name = "transactionSeq", sequenceName = "transaction_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactionSeq")
    private Long id;

    @Column(name = "transactionNum", length = 20)
    private Long transactionNumber;

    @Column(name = "transactionDate", length = 20)
    private LocalDate transactionDate;

    @Column(name = "transactionTime", length = 20)
    private LocalTime transactionTime;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Customer customer;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER) //todo:input in uml this
    private Payment payment;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER) //todo:input in uml this
    private Reservation reservation;

}
