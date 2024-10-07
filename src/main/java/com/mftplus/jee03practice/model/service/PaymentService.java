package com.mftplus.jee03practice.model.service;

import com.mftplus.jee03practice.model.entity.Payment;
import com.mftplus.jee03practice.model.repository.PaymentRepository;

public class PaymentService {

    public static void save(Payment payment) throws Exception {

        try (PaymentRepository paymentRepository = new PaymentRepository()) {
            paymentRepository.save(payment);
        }
    }

    public static void edit(Payment payment) throws Exception {

        try (PaymentRepository paymentRepository = new PaymentRepository()) {
            paymentRepository.edit(payment);
        }
    }
}
