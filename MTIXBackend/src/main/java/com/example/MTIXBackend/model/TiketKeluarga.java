package com.example.MTIXBackend.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("reguler")
@Table(name = "tiketKeluarga")
public class TiketKeluarga extends Tiket implements DiscountTicket{

    private int harga_tiket = 20;
    private int discount = 20;

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
