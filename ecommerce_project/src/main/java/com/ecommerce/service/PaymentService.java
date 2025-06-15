package com.ecommerce.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecommerce.entity.Order;
import com.ecommerce.entity.Payment;
import com.ecommerce.repository.PaymentRepository;

//✅ Handles payment processing. 
//✅ Links payments to orders.

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment processPayment(Order order, String method, String status) {
        Payment payment = new Payment(null, order, method, status);
        return paymentRepository.save(payment);
    }

    public Optional<Payment> getPaymentByOrderId(Long orderId) {
        return paymentRepository.findByOrderId(orderId);
    }
}