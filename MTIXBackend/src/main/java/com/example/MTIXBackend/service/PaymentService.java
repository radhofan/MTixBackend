package com.example.MTIXBackend.service;

import com.example.MTIXBackend.model.Payment;
import com.example.MTIXBackend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    //////////////////////////////////////////////////////// Attributes and Contructors
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    //////////////////////////////////////////////////////// Business Methods
    public List<Payment> viewUserHistory(int keranjang_id){
        return paymentRepository.findByKeranjangId(keranjang_id);
    }

    //////////////////////////////////////////////////////// CRUD Methods
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(int id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        return payment.orElse(null); // Return the user if found, else return null
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment); // Save the new user to the database
    }

    public Payment updatePayment(Payment payment) {
        return paymentRepository.save(payment); // Save the updated user to the database
    }

    public void deletePayment(int id) {
        paymentRepository.deleteById(id); // Delete the user by ID
    }
}
