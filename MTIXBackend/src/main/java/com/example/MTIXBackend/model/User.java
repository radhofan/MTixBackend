package com.example.MTIXBackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    //////////////////////////////////////////////////////// Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    @Column(nullable = false)
    private String nama;

    private String no_telpon;
    private String alamat;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "keranjang_id")
    private Keranjang keranjang;

    //////////////////////////////////////////////////////// Getter and Setter Methods
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_telpon() {
        return no_telpon;
    }

    public void setNo_telpon(String no_telpon) {
        this.no_telpon = no_telpon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public void setKeranjang(Keranjang keranjang){this.keranjang = keranjang;}

    public Keranjang getKeranjang() {return keranjang;}

    public Keranjang viewKeranjang() {
        return this.keranjang;
    }
}
