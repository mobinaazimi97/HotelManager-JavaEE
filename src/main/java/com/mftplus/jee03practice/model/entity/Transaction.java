package com.mftplus.jee03practice.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import java.time.LocalDateTime;

@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
@Entity(name = "transactionEntity")
@Table(name = "transactions_tbl")
@NamedQueries({
        @NamedQuery(name = "Transaction.findByTransactionDateTime", query = "select tt from transactionEntity tt where tt.transactionDateTime = : transactionDateTime"),
        @NamedQuery(name = "Transaction.findByTransactionNumber", query = "select tt from transactionEntity tt where tt.transactionNumber =:transactionNumber")
})

public class Transaction extends Base {
    @Id
    @SequenceGenerator(name = "transactionSeq", sequenceName = "transaction_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactionSeq")
    private Long id;

    @Column(name = "transactionNum", length = 20)
    private Long transactionNumber;

    @Column(name = "transactionDate_Time", length = 20)
    private LocalDateTime transactionDateTime;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Customer customer;

}
