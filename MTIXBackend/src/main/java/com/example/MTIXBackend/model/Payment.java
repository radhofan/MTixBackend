package com.example.MTIXBackend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Au
    private int payment_id;

    private String metode_pembayaran;
    private boolean status_pembayaran;
    private Date tanggal_pembayaran;

    public void processPayment(){

    }

    public void confirmPayment(){

    }

    public void cancelPayment(){

    }

    public void paymentStatus(){

    }

}
