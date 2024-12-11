package com.example.MTIXBackend.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("reguler")
@Table(name = "tiketReguler")
public class TiketReguler extends Tiket{


    private int harga_tiket = 20;

    public void checkAvailability(){

    }

    public void reserveTicket(){

    }

    public void getHargaTiket(){

    }
}
