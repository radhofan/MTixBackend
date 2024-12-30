package com.example.MTIXBackend.model;


import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

    //////////////////////////////////////////////////////// Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate user_id
    private int admin_id;

    private String nama;
    private String email;
    private String password;

    //////////////////////////////////////////////////////// Getter and Setter Methods
    public int getAdmin_id() { return admin_id; }

    public void setAdmin_id(int admin_id) { this.admin_id = admin_id; }

    public String getNama() { return nama; }

    public void setNama(String nama) { this.nama = nama;}

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
