import com.mftplus.jee03practice.model.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Test {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mftEE3");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        Customer customer = Customer.builder()
                .name("hosein")
                .family("hoseini")
                .email("www.hhss@gmail.com")
                .username("hhhh123")
                .password("1234567")
                .enabled(true)
                .build();


        Transaction transaction = Transaction.builder()
                .transactionNumber(6L)
                .transactionDate(LocalDate.of(2000,12,21))
                .build();

        Admin admin = Admin.builder()
                .name("narges")
                .family("niriii")
                .age(LocalDate.of(2000, 1, 4))
                .contactNum("655")
                .username("nrrrrg")
                .password("nrgs123")
                .build();


        Payment payment=Payment.builder()
                .payType("credit")
                .build();


       Employee employee=Employee.builder()
               .name("sanaz")
               .family("sahraei")
               .username("sannn")
               .password("444445")
               .employeeAge(LocalDate.of(1998,8,5))
               .empContactNum("09")
               .jobTitle("db")
               .build();

       Rooms rooms=Rooms.builder()
               .detail("asdfghjkl")
               .requirement("tasisat")
               .build();


       Reservation reservation = Reservation.builder()
               .amount("3")
               //.reservationDateTime(LocalDateTime.of(2024, 7, 3,4,5))
               .build();

        entityManager.persist(customer);
        entityManager.persist(transaction);
        entityManager.persist(admin);
        entityManager.persist(payment);
        transaction.setCustomer(customer);
        entityManager.persist(employee);
        entityManager.persist(rooms);
        entityManager.persist(reservation);

        customer.setCusTransaction(transaction);
        customer.setName("mina");
        transaction.setCustomer(customer);
        transaction.setTransactionNumber(2L);
   //     admin.setAdminTransaction(transaction);
        customer.setName("shiva");
        payment.setCustomer(customer);
       rooms.setRequirement("ssh");
      //  employee.setRoom(rooms);
        reservation.setAmount("2");
        rooms.setReservation(reservation);
        customer.setName("homa");
        reservation.setCustomer(customer);

        entityTransaction.commit();

        Payment payment1= entityManager.find(Payment.class, 1L);
        System.out.println(payment1.getCustomer().getEmail());


        entityManager.close();


    }
}
