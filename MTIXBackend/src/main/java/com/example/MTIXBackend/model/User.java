package com.example.MTIXBackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user") // Optional, customize table name if needed
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate user_id
    private int user_id;

    private String nama;
    private String no_telpon;
    private String alamat;
    private String password;
    private String email;

//    @OneToOne
//    @JoinColumn(name = "keranjang_id", referencedColumnName = "keranjang_id", nullable = false)

//    @OneToOne(cascade = CascadeType.ALL)  // Cascade save operation to Keranjang
//    @JoinColumn(name = "keranjang_id")
      //private Keranjang keranjang;

      //private int keranjang_id


    // Business Methods
    public void viewKeranjang() {

    }

    public void checkout() {

    }

    public void viewHistory() {

    }

//    public void setKeranjang(Keranjang keranjang){
//        this.keranjang = keranjang;
//    }

    // Getter and Setter Methods
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
