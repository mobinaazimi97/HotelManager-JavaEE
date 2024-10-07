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
@Entity(name = "adminEntity")
@Table(name = "Admin_TBL")

public class Admin extends User {
    @Id
    @SequenceGenerator(name = "adminSeq", sequenceName = "admin_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "adminSeq")
    private Long id;

    @Column(name = "contact_number", length = 20)
    private String contactNum;

    @OneToOne
    private Transaction adminTransaction;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
