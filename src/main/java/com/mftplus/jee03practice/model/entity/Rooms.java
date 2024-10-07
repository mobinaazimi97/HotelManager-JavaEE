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
@Entity(name = "roomEntity")
@Table(name = "room_tbl")
public class Rooms {
    @Id
    @SequenceGenerator(name = "roomSeq" , sequenceName = "room_seq" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "roomSeq")
    private Long id;

    @Column(name = "detail", length = 60)
    private String detail;

    @Column(name = "requirement", length = 60)
    private String requirement;

    @OneToOne
    private Reservation reservation;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
