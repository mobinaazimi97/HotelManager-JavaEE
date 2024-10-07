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
@Entity(name = "employeeEntity")
@Table(name = "employee_tbl")
public class Employee {
    @Id
    @SequenceGenerator(name = "employeeSeq", sequenceName = "employee_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "employeeSeq")
    private Long id;

    @Column(name = "first_name", length = 20 , nullable = false)
    private String name;

    @Column(name = "last_name", length = 20  ,nullable = false)
    private String family;

    @Column(name = "username", length = 20 , nullable = false , unique = true)
    private String username;

    @Column(name = "password", length = 20 , nullable = false)
    private String password;

    @Column(name = "birth_date")
    private LocalDate employeeAge;

    @Column(name = "contact_num", length = 20 , nullable = false)
    private Long empContactNum;

    @Column(name = "your_job_title", length = 40 , nullable = false)
    private String jobTitle;

    @OneToOne
    private Rooms room;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
