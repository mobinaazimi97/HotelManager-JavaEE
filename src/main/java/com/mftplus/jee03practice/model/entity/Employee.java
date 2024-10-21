package com.mftplus.jee03practice.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
@Entity(name = "employeeEntity")
@Table(name = "employee_tbl")
@NamedQueries({
        @NamedQuery(name = "Employee.findByFamily", query = "select ee from employeeEntity ee where ee.family like : family"),
        @NamedQuery(name = "Employee.findByUsernameAndPassword", query = "select ee from employeeEntity ee where ee.username like :username and ee.password like : password"),
        @NamedQuery(name = "Employee.findByJobTitle", query = "select ee from employeeEntity ee where ee.jobTitle like : jobTitle"),
        @NamedQuery(name = "Employee.findByEmpContactNum", query = "select ee from employeeEntity ee where ee.empContactNum like : empContactNum"),
        @NamedQuery(name = "Employee.findByRoomNumber", query = "select ee from employeeEntity ee where ee.roomEmployee.roomNumber = : roomNumber")
})

public class Employee extends Base {
    @Id
    @SequenceGenerator(name = "employeeSeq", sequenceName = "employee_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeSeq")
    private Long id;

    @Column(name = "first_name", length = 20, nullable = false)
    private String name;

    @Column(name = "last_name", length = 20, nullable = false)
    private String family;

    @Column(name = "username", length = 20, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 20, nullable = false)
    private String password;

    @Column(name = "birth_date")
    private LocalDate employeeAge;

    @Column(name = "contact_num", nullable = false)
    private String empContactNum;

    @Column(name = "your_job_title", length = 40, nullable = false)
    private String jobTitle;

    //    @OneToOne(cascade = {CascadeType.PERSIST , CascadeType.MERGE  ,CascadeType.DETACH  ,CascadeType.REFRESH})
//    @OneToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
//    private Rooms rooms;
    @ManyToOne(cascade = CascadeType.PERSIST , fetch = FetchType.EAGER)
    private Rooms roomEmployee;
}
