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
@Entity(name = "transactionEntity")
@Table(name = "transactions_tbl")
public class Transaction {
    @Id
    @SequenceGenerator(name = "transactionSeq",sequenceName = "transaction_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "transactionSeq")
    private Long id;

    @Column(name = "transactionNum", length = 20)
    private Long transactionNumber;

    @Column(name = "transactionDate", length = 20)
    private LocalDate transactionDate;

    @OneToOne
    private Customer customer;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
