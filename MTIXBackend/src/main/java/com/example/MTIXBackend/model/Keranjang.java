package com.example.MTIXBackend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "keranjang")
public class Keranjang {

    //////////////////////////////////////////////////////// Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate user_id
    private int keranjang_id;
    private double total_harga;
    private int jumlah_tiket;
    private String jenis_tiket = "Tiket Reguler";

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "museum_id", unique = false)  // Disable uniqueness
    private Museum museum;

    //////////////////////////////////////////////////////// Getter and Setter Methods
    public int getKeranjang_id() {
        return keranjang_id;
    }

    public void setKeranjang_id(int keranjang_id) {
        this.keranjang_id = keranjang_id;
    }

    public double getTotal_harga() {
        return total_harga;
    }

    public void setTotal_harga(double total_harga) {
        this.total_harga = total_harga;
    }

    public String getJenis_tiket() {
        return jenis_tiket;
    }

    public void setJenis_tiket(String jenis_tiket) {
        this.jenis_tiket = jenis_tiket;
    }

    public int getJumlah_tiket() {
        return jumlah_tiket;
    }

    public void setJumlah_tiket(int jumlah_tiket) {
        this.jumlah_tiket = jumlah_tiket;
    }

    public Museum getMuseum() {
        return museum;
    }

    public void setMuseum(Museum museum) {
        this.museum = museum;
    }
}
