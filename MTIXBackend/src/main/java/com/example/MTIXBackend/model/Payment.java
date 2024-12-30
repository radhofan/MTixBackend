package com.example.MTIXBackend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "payment")
public class Payment {

    //////////////////////////////////////////////////////// Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Au
    private int payment_id;

    private String metode_pembayaran;
    private boolean status_pembayaran;
    private Date tanggal_pembayaran;
    private String bank;

    @ManyToOne
    @JoinColumn(name = "museum_id")
    private Museum museum;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "keranjang_id")
    private Keranjang keranjang;

    private double total_harga;
    private int jumlah_tiket;
    private String jenis_tiket;

    //////////////////////////////////////////////////////// Getter and Setter Methods
    public int getPayment_id() {return payment_id;}

    public void setPayment_id(int payment_id) {this.payment_id = payment_id;}

    public String getMetode_pembayaran() {return metode_pembayaran;}

    public void setMetode_pembayaran(String metode_pembayaran) {this.metode_pembayaran = metode_pembayaran;}

    public boolean isStatus_pembayaran() {return status_pembayaran;}

    public void setStatus_pembayaran(boolean status_pembayaran) {this.status_pembayaran = status_pembayaran;}

    public Date getTanggal_pembayaran() {return tanggal_pembayaran;}

    public void setTanggal_pembayaran(Date tanggal_pembayaran) {this.tanggal_pembayaran = tanggal_pembayaran;}

    public String getBank() {return bank;}

    public void setBank(String bank) {this.bank = bank;}

    public Keranjang getKeranjang() {return keranjang;}

    public void setKeranjang(Keranjang keranjang) {this.keranjang = keranjang;}

    public double getTotal_harga() {return total_harga;}

    public void setTotal_harga(double total_harga) {this.total_harga = total_harga;}

    public int getJumlah_tiket() {return jumlah_tiket;}

    public void setJumlah_tiket(int jumlah_tiket) {this.jumlah_tiket = jumlah_tiket;}

    public String getJenis_tiket() {return jenis_tiket;}

    public void setJenis_tiket(String jenis_tiket) {this.jenis_tiket = jenis_tiket;}

    public Museum getMuseum() {
        return museum;
    }

    public void setMuseum(Museum museum) {
        this.museum = museum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
