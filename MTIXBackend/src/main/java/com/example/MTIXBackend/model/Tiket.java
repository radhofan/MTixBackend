package com.example.MTIXBackend.model;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Tiket {

    //////////////////////////////////////////////////////// Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate user_id
    private int tiket_id;

    String kode_tiket;

    @ManyToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "payment_id", nullable = false)
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "museum_id", referencedColumnName = "museum_id", nullable = false)
    private Museum museum;

    @ManyToOne
    @JoinColumn(name = "keranjang_id", referencedColumnName = "keranjang_id", nullable = false)
    private Keranjang keranjang;

    //////////////////////////////////////////////////////// Business Methods

    //////////////////////////////////////////////////////// Getter and Setter Methods
    public int getTiket_id() {
        return tiket_id;
    }

    public void setTiket_id(int tiket_id) {
        this.tiket_id = tiket_id;
    }

    public String getKode_tiket() {return kode_tiket;}

    public void setKode_tiket(String kode_tiket) {this.kode_tiket = kode_tiket;}

    public Payment getPayment() {return payment;}

    public void setPayment(Payment payment) {this.payment = payment;}

    public Museum getMuseum() {return museum;}

    public void setMuseum(Museum museum) {this.museum = museum;}

    public Keranjang getKeranjang() {return keranjang;}

    public void setKeranjang(Keranjang keranjang) {this.keranjang = keranjang;}

}
