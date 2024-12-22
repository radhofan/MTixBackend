package com.example.MTIXBackend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "museum")
public class Museum {

    //////////////////////////////////////////////////////// Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate user_id
    private int museum_id;

    private String nama;
    private String lokasi;
    private String no_telpon;
    private String keterangan;
    private double rating;
    private int jumlah_tiket;
    private int tiketReguler_price;
    private int tiketPelajar_price;
    private int tiketKeluarga_price;

    //////////////////////////////////////////////////////// Business Methods
    public void viewDetails(){

    }

    public void rateMuseum(){

    }

    //////////////////////////////////////////////////////// Getter and Setter Methods
    public int getMuseum_id() {
        return museum_id;
    }

    public void setMuseum_id(int museum_id) {
        this.museum_id = museum_id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLokasi() {
        return lokasi;
    }

    public int getJumlah_tiket() {
        return jumlah_tiket;
    }

    public void setJumlah_tiket(int jumlah_tiket) {
        this.jumlah_tiket = jumlah_tiket;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getNo_telpon() {
        return no_telpon;
    }

    public void setNo_telpon(String no_telpon) {
        this.no_telpon = no_telpon;
    }

    public int getTiketReguler_price() {return tiketReguler_price;}

    public void setTiketReguler_price(int tiketReguler_price) {this.tiketReguler_price = tiketReguler_price;}

    public int getTiketPelajar_price() {return tiketPelajar_price;}

    public void setTiketPelajar_price(int tiketPelajar_price) {this.tiketPelajar_price = tiketPelajar_price;}

    public int getTiketKeluarga_price() {return tiketKeluarga_price;}

    public void setTiketKeluarga_price(int tiketKeluarga_price) {this.tiketKeluarga_price = tiketKeluarga_price;}
}
