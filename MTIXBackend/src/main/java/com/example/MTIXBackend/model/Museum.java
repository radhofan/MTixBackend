package com.example.MTIXBackend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "museum")
public class Museum {

    //////////////////////////////////////////////////////// Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int museum_id;

    @Column(nullable = false)
    private String nama;

    private String lokasi;
    private String no_telpon;
    private String keterangan;
    private double rating;
    private int jumlah_tiket = 100;

    @Column(nullable = false)
    private int tiket_reguler_price;

    @Column(nullable = false)
    private int tiket_pelajar_price;

    @Column(nullable = false)
    private int tiket_keluarga_price;

    private int likes = 1000;
    private String jam_operasional;
    private String longitude;
    private String latitude;

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

    public int getTiket_reguler_price() {return tiket_reguler_price;}

    public void setTiket_reguler_price(int tiket_reguler_price) {this.tiket_reguler_price = tiket_reguler_price;}

    public int getTiket_pelajar_price() {return tiket_pelajar_price;}

    public void setTiket_pelajar_price(int tiket_pelajar_price) {this.tiket_pelajar_price = tiket_pelajar_price;}

    public int getTiket_keluarga_price() {return tiket_keluarga_price;}

    public void setTiket_keluarga_price(int tiket_keluarga_price) {this.tiket_keluarga_price = tiket_keluarga_price;}

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getJam_operasional() {
        return jam_operasional;
    }

    public void setJam_operasional(String jam_operasional) {
        this.jam_operasional = jam_operasional;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
