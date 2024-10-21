package com.mftplus.jee03practice.model.service;

import com.mftplus.jee03practice.model.entity.Payment;
import com.mftplus.jee03practice.model.repository.CrudRepository;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;

public class PaymentService implements Service<Payment, Long> {
    @Getter
    private static PaymentService paymentService = new PaymentService();

    private PaymentService() {
    }

    @Override
    public void save(Payment payment) throws Exception {
        try (CrudRepository<Payment, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.save(payment);

        }
    }

    @Override
    public void edit(Payment payment) throws Exception {
        try (CrudRepository<Payment, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.edit(payment);
        }
    }

    @Override
    public void remove(Long id) throws Exception {
        try (CrudRepository<Payment, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.remove(id, Payment.class);
        }
    }

    @Override
    public Payment findById(Long id) throws Exception {
        try (CrudRepository<Payment, Long> crudRepository = new CrudRepository<>()) {
            return crudRepository.findById(id, Payment.class);

        }
    }

    @Override
    public List<Payment> findAll() throws Exception {
        try (CrudRepository<Payment, Long> crudRepository = new CrudRepository<>()) {
            return crudRepository.findAll(Payment.class);
        }
    }


    public Payment findByPayType(String payType) throws Exception {
        try (CrudRepository<Payment, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("payType", payType);
            List<Payment> payments = crudRepository.findBy("Payment.findByPayType", params, Payment.class);
            return (payments.isEmpty()) ? null : payments.get(0);
        }
    }

    public Payment findByCusUserPass(String username, String password) throws Exception {
        try (CrudRepository<Payment, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("username", username);
            params.put("password", password);
            List<Payment> payments = crudRepository.findBy("Payment.cusUserAndPass", params, Payment.class);
            if (payments.isEmpty()) {
                return null;
            } else {
                return payments.get(0);
            }
        }
    }

    public Payment findByCusEmail(String email) throws Exception {
        try (CrudRepository<Payment, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("email", email);
            List<Payment> payments = crudRepository.findBy("Payment.cusEmail", params, Payment.class);
            if (payments.isEmpty()) {
                return null;
            } else {
                return payments.get(0);
            }
        }
    }

    public Payment findByCusTransNumber(Long transactionNumber) throws Exception {
        try (CrudRepository<Payment, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("transactionNumber", transactionNumber);
            List<Payment> payments = crudRepository.findBy("Payment.findByCusTransNumber", params, Payment.class);
            if (payments.isEmpty()) {
                return null;
            } else {
                return payments.get(0);
            }
        }
    }

    public Payment findByRoomNumber(String roomNumber) throws Exception {
        try (CrudRepository<Payment, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("rooms", roomNumber);
            List<Payment> payments = crudRepository.findBy("Payment.findByRoomNumber", params, Payment.class);
            if (payments.isEmpty()) {
                return null;
            } else {
                return payments.get(0);
            }
        }
    }
}
