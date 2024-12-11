package com.example.MTIXBackend.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("pelajar")
@Table(name = "tiketPelajar")
public class TiketPelajar extends Tiket implements DiscountTicket{

    private int harga_tiket = 20;
    private int discount = 10;

    public void checkAvailability(){

    }

    public void reserveTicket(){

    }

    public void getHargaTiket(){

    }

    public int getDiscountRate(){
        return discount;
    }
}
