package com.example.MTIXBackend.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("reguler")
@Table(name = "tiketKeluarga")
public class TiketKeluarga extends Tiket implements GroupTicket {

    //////////////////////////////////////////////////////// Attributes
    private String nama_keluarga;
    private int jumlah_orang;

    //////////////////////////////////////////////////////// Business Methods
    public void setGroupName(String name){
        this.nama_keluarga = name;
    }

    public void setGroupCount(int count){
        this.jumlah_orang = count;
    }

    //////////////////////////////////////////////////////// Getter and Setter Methods
    public int getJumlah_Orang() {return jumlah_orang;}

    public void setJumlah_Orang(int jumlah_orang) {jumlah_orang = jumlah_orang;}

    public String getNama_Sekolah() {return nama_keluarga;}

    public void setNama_Sekolah(String nama_keluarga) {nama_keluarga = nama_keluarga;}

}
