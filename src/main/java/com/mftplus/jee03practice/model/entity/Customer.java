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
@Entity(name = "customerEntity")
@Table(name = "customer_tbl")

public class Customer {

    @Id
    @SequenceGenerator(name = "customerSeq", sequenceName = "customer_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "customerSeq")
    private Long id;

    @Column(name = "name", length = 20 , nullable = false)
    private String name;

    @Column(name = "family", length = 20 , nullable = false)
    private String family;

    @Column(name = "username", length = 20 , nullable = false , unique = true)
    private String username;

    @Column(name = "password", length = 20  ,nullable = false)
    private String password;

    @Column(name = "email", length = 30 , nullable = false)
    private String email;

    private Boolean enabled;

    @OneToOne
    private Transaction cusTransaction;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
