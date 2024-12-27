package com.example.MTIXBackend.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("reguler")
@Table(name = "tiketReguler")
public class TiketReguler extends Tiket{

    //////////////////////////////////////////////////////// Attributes
    @Column(name = "status")
    private String status; // New status variable

    //////////////////////////////////////////////////////// Getters and Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
