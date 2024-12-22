package com.example.MTIXBackend.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("reguler")
@Table(name = "tiketReguler")
public class TiketReguler extends Tiket{

    //////////////////////////////////////////////////////// Attributes


    //////////////////////////////////////////////////////// Business Methods

}
