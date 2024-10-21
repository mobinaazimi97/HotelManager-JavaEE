package com.mftplus.jee03practice.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
@Entity(name = "adminEntity")
@Table(name = "Admin_TBL")

@NamedQueries({
        @NamedQuery(name = "Admin.findByFamily", query = "select aa from adminEntity aa where aa.family like : family"),
        @NamedQuery(name = "Admin.findByUsernameAndPassword", query = "select aa from adminEntity aa where aa.username like:username and aa.password like : password"),
        @NamedQuery(name = "Admin.findByAdminContactNum", query = "select aa from adminEntity aa where aa.contactNum   like: contactNum"),
        @NamedQuery(name = "Admin.findByTransactionDate", query = "select aa from adminEntity aa where aa.adminTransaction.transactionDate = : transactionDate "),
        @NamedQuery(name = "Admin.findByTransactionTime", query = "select aa from adminEntity aa where aa.adminTransaction.transactionTime = : transactionTime"),
        @NamedQuery(name = "Admin.findByTransactionNum", query = "select aa from adminEntity aa where aa.adminTransaction.transactionNumber  = : transactionNumber")
 //todo->@NamedQuery(name = "Admin.findByTransactionId", query = "select aa from adminEntity aa where aa.adTransactions  = : transactionNumber")

// TODO->findByCusEmail
// TODO->findByCusUsername
// TODO->findByCusUsername&Pass

})


public class Admin extends User {
    @Id
    @SequenceGenerator(name = "adminSeq", sequenceName = "admin_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adminSeq")

    private Long id;

    @Column(name = "contact_number", length = 20)
    private String contactNum;

    @Column(name = "admin_email", length = 50)
    private String email;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Transaction adminTransaction;

//    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//    private List<Transaction> adTransactions=new ArrayList<>();

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Customer>adCustomers=new ArrayList<>();
}
