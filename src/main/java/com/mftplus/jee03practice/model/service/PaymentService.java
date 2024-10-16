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
}
