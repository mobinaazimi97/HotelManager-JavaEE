package com.mftplus.jee03practice.model.entity;

import com.google.gson.Gson;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity(name = "paymentEntity")
@Table(name = "payment_tbl")
public class Payment {
    @Id
    @SequenceGenerator(name = "paymentSeq", sequenceName = "payment_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "paymentSeq")
    private Long id;

    @Column(name = "payment_type", length = 20 , nullable = false)
    private String payType;

    @OneToOne
    private Customer customer;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
