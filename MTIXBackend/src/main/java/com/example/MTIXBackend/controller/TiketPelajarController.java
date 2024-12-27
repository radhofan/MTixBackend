package com.example.MTIXBackend.controller;

import com.example.MTIXBackend.model.TiketKeluarga;
import com.example.MTIXBackend.model.TiketPelajar;
import com.example.MTIXBackend.service.TiketPelajarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiketpelajars") // Define base URL for TiketPelajar-related operations
public class TiketPelajarController {

    //////////////////////////////////////////////////////// Attributes
    private final TiketPelajarService tiketPelajarService;

    // Inject TiketPelajarService into the controller using constructor-based dependency injection
    @Autowired
    public TiketPelajarController(TiketPelajarService tiketPelajarService) {
        this.tiketPelajarService = tiketPelajarService;
    }

    //////////////////////////////////////////////////////// Business Methods
    @PostMapping("/createTicket/{nama_sekolah}/{jumlah_orang}")
    @CrossOrigin(origins = "http://localhost:3000")
    public TiketPelajar createTiket(@PathVariable String nama_sekolah, @PathVariable int jumlah_orang, @RequestBody TiketPelajar tiketPelajar) {
        return tiketPelajarService.createTiket(nama_sekolah, jumlah_orang, tiketPelajar);
    }

    //////////////////////////////////////////////////////// CRUD Methods
    // Get all tiketpelajars
    @GetMapping
    public List<TiketPelajar> getAllTiketPelajars() {
        return tiketPelajarService.getAllTiketPelajars(); // Delegate to the service layer
    }

    // Get a tiketpelajar by ID
    @GetMapping("/{id}")
    public TiketPelajar getTiketPelajarById(@PathVariable int id) {
        return tiketPelajarService.getTiketPelajarById(id); // Get tiketpelajar by ID
    }

    // Create a new tiketpelajar
    @PostMapping
    public TiketPelajar createTiketPelajar(@RequestBody TiketPelajar tiketPelajar) {
        return tiketPelajarService.createTiketPelajar(tiketPelajar); // Delegate to service for creating the tiketpelajar
    }

    // Delete a tiketpelajar by ID
    @DeleteMapping("/{id}")
    public void deleteTiketPelajar(@PathVariable int id) {
        tiketPelajarService.deleteTiketPelajar(id); // Delete the tiketpelajar by ID
    }

    // Update a tiketpelajar
    @PutMapping
    public TiketPelajar updateTiketPelajar(@RequestBody TiketPelajar tiketPelajar) {
        return tiketPelajarService.updateTiketPelajar(tiketPelajar); // Update the tiketpelajar
    }

    // Endpoint to get TiketPelajar by status
    @GetMapping("/status/{status}")
    public List<TiketPelajar> getTiketPelajarsByStatus(@PathVariable String status) {
        return tiketPelajarService.getTiketPelajarsByStatus(status);
    }
}