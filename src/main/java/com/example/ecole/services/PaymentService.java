package com.example.ecole.services;

import com.example.ecole.entity.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getAllPayments();
    Payment getPaymentById(int paymentId);
    Payment createPayment(Payment payment);
    Payment updatePayment(int paymentId, Payment paymentDetails);
    void deletePayment(int paymentId);
    // Business logic methods
    void processPayment(int paymentId);
    void refundPayment(int paymentId);
    void generateReceipt(int paymentId);
}