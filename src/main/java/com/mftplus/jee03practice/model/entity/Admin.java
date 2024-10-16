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
@Entity(name = "adminEntity")
@Table(name = "Admin_TBL")

@NamedQueries({
        @NamedQuery(name ="Admin.findByFamily",query = "select aa from adminEntity aa where aa.family like : family"),
        @NamedQuery(name = "Admin.findByUsernameAndPassword" , query = "select aa from adminEntity aa where aa.username like :username and aa.password like : password"),
        @NamedQuery(name = "Admin.findByAdminContactNum",query = "select aa from adminEntity aa where aa.contactNum LIKE : contactNum")
})


public class Admin extends User {
    @Id
    @SequenceGenerator(name = "adminSeq", sequenceName = "admin_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "adminSeq")

    private Long id;

    @Column(name = "contact_number", length = 20)
    private String contactNum;

    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private Transaction adminTransaction;

//    @Override
//    public String toString() {
//        return new Gson().toJson(this);
//    }

}
