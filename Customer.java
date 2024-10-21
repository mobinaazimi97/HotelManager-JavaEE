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
@Entity(name = "customerEntity")
@Table(name = "customer_tbl")

@NamedQueries({
        @NamedQuery(name = "Customer.findByFamily", query = "select cc from customerEntity cc where cc.family like : family"),
        @NamedQuery(name = "Customer.findByUsernameAndPassword", query = "select cc from customerEntity cc where cc.username like :username and cc.password like : password"),
        @NamedQuery(name = "Customer.findByTransactionDate", query = "select cc from customerEntity cc where cc.cusTransaction.transactionDate = : transactionDate"),
        @NamedQuery(name = "Customer.findByTransactionTime", query = "select cc from customerEntity cc where cc.cusTransaction.transactionTime = : transactionTime"),
        @NamedQuery(name = "Customer.findByTransactionNum", query = "select cc from customerEntity cc where cc.cusTransaction.transactionNumber = : transactionNumber")



})


public class Customer extends Base {

    @Id
    @SequenceGenerator(name = "customerSeq", sequenceName = "customer_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerSeq")
    private Long id;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "family", length = 20, nullable = false)
    private String family;

    @Column(name = "username", length = 20, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 20, nullable = false)
    private String password;

    @Column(name = "email", length = 30, nullable = false)
    private String email;

    private Boolean enabled;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Transaction cusTransaction;

}
