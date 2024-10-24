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
        @NamedQuery(name = "Admin.findByFamily", query = "select aa from adminEntity aa where aa.family like : family"),
        @NamedQuery(name = "Admin.findByUsernameAndPassword", query = "select aa from adminEntity aa where aa.username like:username and aa.password like : password"),
        @NamedQuery(name = "Admin.findByAdminContactNum", query = "select aa from adminEntity aa where aa.contactNum   like: contactNum"),
        @NamedQuery(name = "Admin.findByTransactionDate", query = "select aa from adminEntity aa where aa.adminTransaction.transactionDate = : transactionDate "),
        @NamedQuery(name = "Admin.findByTransactionTime", query = "select aa from adminEntity aa where aa.adminTransaction.transactionTime = : transactionTime"),
        @NamedQuery(name = "Admin.findByTransactionNum", query = "select aa from adminEntity aa where aa.adminTransaction.transactionNumber  = : transactionNumber"),
        @NamedQuery(name = "Admin.findByCusEmail", query = "select aa from adminEntity aa where aa.adminCustomer.email  = : email"),
        @NamedQuery(name = "Admin.findByCusEmailTrans", query = "select aa from adminEntity aa where aa.adminTransaction.customer.email  = : email"),
        @NamedQuery(name = "Admin.findByCusUsername", query = "select aa from adminEntity aa where aa.adminCustomer.username  = : username"),
        @NamedQuery(name = "Admin.findByCusUserAndPass", query = "select aa from adminEntity aa where aa.adminCustomer.username  = : username and aa.adminCustomer.password=:password"),
        @NamedQuery(name = "Admin.findByPayType", query = "select aa from adminEntity aa where aa.payment.payType  = : payType"),
        @NamedQuery(name = "Admin.findByPayId", query = "select aa from adminEntity aa where aa.payment.id  = : id"),
        @NamedQuery(name = "Admin.findByReserveId", query = "select aa from adminEntity aa where aa.reservation.id  = : id"),
        @NamedQuery(name = "Admin.findByReserveDate", query = "select aa from adminEntity aa where aa.reservation.reservationDate  = : reservationDate"),
        @NamedQuery(name = "Admin.findByReserveTime", query = "select aa from adminEntity aa where aa.reservation.reservationTime  = : reservationTime"),
        @NamedQuery(name = "Admin.findByRoomId", query = "select aa from adminEntity aa where aa.roomsAdmin.id  = : id"),
        @NamedQuery(name = "Admin.findByRoomNum", query = "select aa from adminEntity aa where aa.roomsAdmin.roomNumber  = : roomNumber"),
        @NamedQuery(name = "Admin.findByRoomReserved", query = "select aa from adminEntity aa where aa.roomsAdmin.reservation.rooms.roomNumber  = : roomNumber"),
        @NamedQuery(name = "Admin.findByRoomReservedDate", query = "select aa from adminEntity aa where aa.roomsAdmin.reservation.reservationDate  = : reservationDate"),
        @NamedQuery(name = "Admin.findByRoomReservedTime", query = "select aa from adminEntity aa where aa.roomsAdmin.reservation.reservationTime  = : reservationTime"),
        @NamedQuery(name = "Admin.findByEmpRoomReq", query = "select aa from adminEntity aa where aa.employeeAdmin.roomEmployee.requirement  = : requirement"),
        @NamedQuery(name = "Admin.findByEmployeeRoomNumber", query = "select aa from adminEntity aa where aa.employeeAdmin.roomEmployee.roomNumber  = : roomNumber"),
        @NamedQuery(name = "Admin.findByEmpNumber", query = "select aa from adminEntity aa where aa.employeeAdmin.empContactNum  = : empContactNum"),
        @NamedQuery(name = "Admin.findByEmpJob", query = "select aa from adminEntity aa where aa.employeeAdmin.jobTitle  = : jobTitle"),
        @NamedQuery(name = "Admin.findByTotalReserves", query = "select aa from adminEntity aa where aa.reservation.rooms.roomNumber  = : roomNumber"),
        @NamedQuery(name = "Admin.findByEmpNameAndFamily", query = "select aa from adminEntity aa where aa.employeeAdmin.name  = : name and aa.employeeAdmin.family = : family")
        //todo->@NamedQuery(name = "Admin.findByTransactionId", query = "select aa from adminEntity aa where aa.adTransactions  = : transactionNumber")
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

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Customer adminCustomer;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Payment payment;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Reservation reservation;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Rooms roomsAdmin;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Employee employeeAdmin;

    //    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//    private List<Transaction> adTransactions=new ArrayList<>();

//    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//    private List<Customer>adCustomers=new ArrayList<>();
}
