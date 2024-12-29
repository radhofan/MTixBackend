package com.example.MTIXBackend.controller;

import com.example.MTIXBackend.model.TiketKeluarga;
import com.example.MTIXBackend.model.TiketReguler;
import com.example.MTIXBackend.repository.MuseumRepository;
import com.example.MTIXBackend.service.MuseumService;
import com.example.MTIXBackend.service.TiketKeluargaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiketkeluargas") // Define base URL for TiketKeluarga-related operations
public class TiketKeluargaController {

    //////////////////////////////////////////////////////// Attributes
    private final TiketKeluargaService tiketKeluargaService;

    // Inject TiketKeluargaService into the controller using constructor-based dependency injection
    @Autowired
    public TiketKeluargaController(TiketKeluargaService tiketKeluargaService) {
        this.tiketKeluargaService = tiketKeluargaService;
    }

    //////////////////////////////////////////////////////// Business Methods
    @PostMapping("/createTicket/{nama_keluarga}/{jumlah_orang}")
    @CrossOrigin(origins = "http://localhost:3000")
    public TiketKeluarga createTiket(@PathVariable String nama_keluarga, @PathVariable int jumlah_orang, @RequestBody TiketKeluarga tiketKeluarga) {
        return tiketKeluargaService.createTiket(nama_keluarga, jumlah_orang, tiketKeluarga);
    }

    @GetMapping("/status/{keranjang_id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<TiketKeluarga> getTicketsByKeranjang(@PathVariable int keranjang_id) {
        return tiketKeluargaService.getTicketKeluargasByKeranjang(keranjang_id);
    }

    @PostMapping("/status/cancel/{tiket_id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public TiketKeluarga cancelTicket(@PathVariable int tiket_id) {
        return tiketKeluargaService.cancelTicket(tiket_id);
    }

    //////////////////////////////////////////////////////// CRUD Methods
    // Get all tiketkeluargas
    @GetMapping
    public List<TiketKeluarga> getAllTiketKeluargas() {
        return tiketKeluargaService.getAllTiketKeluargas(); // Delegate to the service layer
    }

    // Get a tiketkeluarga by ID
    @GetMapping("/{id}")
    public TiketKeluarga getTiketKeluargaById(@PathVariable int id) {
        return tiketKeluargaService.getTiketKeluargaById(id); // Get tiketkeluarga by ID
    }

    // Create a new tiketkeluarga
    @PostMapping
    public TiketKeluarga createTiketKeluarga(@RequestBody TiketKeluarga tiketKeluarga) {
        return tiketKeluargaService.createTiketKeluarga(tiketKeluarga); // Delegate to service for creating the tiketkeluarga
    }

    // Update a tiketkeluarga
    @PutMapping
    public TiketKeluarga updateTiketKeluarga(@RequestBody TiketKeluarga tiketKeluarga) {
        return tiketKeluargaService.updateTiketKeluarga(tiketKeluarga); // Update the tiketkeluarga
    }

    // Delete a tiketkeluarga by ID
    @DeleteMapping("/{id}")
    public void deleteTiketKeluarga(@PathVariable int id) {
        tiketKeluargaService.deleteTiketKeluarga(id); // Delete the tiketkeluarga by ID
    }
}
