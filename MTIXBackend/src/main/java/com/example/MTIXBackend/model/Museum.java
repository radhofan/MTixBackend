package com.example.MTIXBackend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "museum")
public class Museum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate user_id
    private int museum_id;

    private String nama;
    private String lokasi;
    private String no_telpon;
    private String keterangan;
    private double rating;

    @OneToMany(mappedBy = "museum")
    private List<TiketReguler> tiketRegulerList;

    @OneToMany(mappedBy = "museum")
    private List<TiketKeluarga> tiketKeluargaList;

    @OneToMany(mappedBy = "museum")
    private List<TiketPelajar> tiketPelajarList;

    private List<Integer> ratingList;
    private int jumlah_tiket;

    public void viewDetails(){

    }

    public void rateMuseum(){

    }

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

    public List<Integer> getRatingList() {
        return ratingList;
    }

    public int getJumlah_tiket() {
        return jumlah_tiket;
    }

    public void setJumlah_tiket(int jumlah_tiket) {
        this.jumlah_tiket = jumlah_tiket;
    }

    public void setRatingList(List<Integer> ratingList) {
        this.ratingList = ratingList;
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
}
