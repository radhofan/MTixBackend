package com.example.MTIXBackend.model;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Tiket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate user_id
    private int tiket_id;

    @ManyToOne
    @JoinColumn(name = "museum_id", referencedColumnName = "museum_id", nullable = false)
    private Museum museum;

    @ManyToOne
    @JoinColumn(name = "keranjang_id", referencedColumnName = "keranjang_id", nullable = false) // Foreign key for Keranjang
    private Keranjang keranjang;


    public abstract void checkAvailability();

    public abstract void reserveTicket();

    public abstract void getHargaTiket();

    public int getTiket_id() {
        return tiket_id;
    }

    public void setTiket_id(int tiket_id) {
        this.tiket_id = tiket_id;
    }


}
