package com.example.MTIXBackend.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("pelajar")
@Table(name = "tiketPelajar")
public class TiketPelajar extends Tiket implements GroupTicket {

    //////////////////////////////////////////////////////// Attributes
    private String nama_sekolah;
    private int jumlah_orang;


    //////////////////////////////////////////////////////// Business Methods
    public void setGroupName(String name){
        this.nama_sekolah = name;
    }

    public void setGroupCount(int count){
        this.jumlah_orang = count;
    }

    //////////////////////////////////////////////////////// Getter and Setter Methods
    public int getJumlah_Orang() {return jumlah_orang;}

    public void setJumlah_Orang(int jumlah_orang) {jumlah_orang = jumlah_orang;}

    public String getNama_Sekolah() {return nama_sekolah;}

    public void setNama_Sekolah(String nama_sekolah) {nama_sekolah = nama_sekolah;}

}
