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

    //////////////////////////////////////////////////////// Getter and Setter Methods
    public int getAdmin_id() { return admin_id; }

    public void setAdmin_id(int admin_id) { this.admin_id = admin_id; }

    public String getNama() { return nama; }

    public void setNama(String nama) { this.nama = nama;}
}
