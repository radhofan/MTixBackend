package com.example.MTIXBackend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "keranjang")
public class Keranjang {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate user_id
    private int keranjang_id;

//    @OneToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
//    private User user;

    private List<Integer> tiket_id;
    private double total_harga;
    private int jumlah_tiket;

    public void addTiket(){

    }

    public void removeTiket(){

    }

    public void calculateTotal(){

    }

    public int getKeranjang_id() {
        return keranjang_id;
    }

    public void setKeranjang_id(int keranjang_id) {
        this.keranjang_id = keranjang_id;
    }

    public List<Integer> getTiket_id() {
        return tiket_id;
    }

    public void setTiket_id(List<Integer> tiket_id) {
        this.tiket_id = tiket_id;
    }

    public double getTotal_harga() {
        return total_harga;
    }

    public void setTotal_harga(double total_harga) {
        this.total_harga = total_harga;
    }

    public int getJumlah_tiket() {
        return jumlah_tiket;
    }

    public void setJumlah_tiket(int jumlah_tiket) {
        this.jumlah_tiket = jumlah_tiket;
    }
}
