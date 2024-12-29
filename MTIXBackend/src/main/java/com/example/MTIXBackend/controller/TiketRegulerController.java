package com.example.MTIXBackend.controller;

import com.example.MTIXBackend.model.TiketPelajar;
import com.example.MTIXBackend.model.TiketReguler;
import com.example.MTIXBackend.service.TiketRegulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiketregulers") // Define base URL for TiketReguler-related operations
public class TiketRegulerController {

    //////////////////////////////////////////////////////// Attributes
    private final TiketRegulerService tiketRegulerService;

    // Inject TiketRegulerService into the controller using constructor-based dependency injection
    @Autowired
    public TiketRegulerController(TiketRegulerService tiketRegulerService) {
        this.tiketRegulerService = tiketRegulerService;
    }

    //////////////////////////////////////////////////////// Business Methods
    @PostMapping("/createTicket")
    public TiketReguler createTiket(@RequestBody TiketReguler tiketReguler) {
        return tiketRegulerService.createTiket(tiketReguler);
    }

    @GetMapping("/status/{keranjang_id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<TiketReguler> getTiketRegulersByKeranjang(@PathVariable int keranjang_id) {
        return tiketRegulerService.getTiketRegulersByKeranjang(keranjang_id);
    }

    @PostMapping("/status/cancel/{tiket_id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public TiketReguler cancelTicket(@PathVariable int tiket_id) {
        return tiketRegulerService.cancelTicket(tiket_id);
    }

    //////////////////////////////////////////////////////// CRUD Methods
    // Get all tiketregulers
    @GetMapping
    public List<TiketReguler> getAllTiketRegulers() {
        return tiketRegulerService.getAllTiketRegulers(); // Delegate to the service layer
    }

    // Get a tiketreguler by ID
    @GetMapping("/{id}")
    public TiketReguler getTiketRegulerById(@PathVariable int id) {
        return tiketRegulerService.getTiketRegulerById(id); // Get tiketreguler by ID
    }

    // Create a new tiketreguler
    @PostMapping
    public TiketReguler createTiketReguler(@RequestBody TiketReguler tiketReguler) {
        return tiketRegulerService.createTiketReguler(tiketReguler); // Delegate to service for creating the tiketreguler
    }

    // Update a tiketreguler
    @PutMapping
    public TiketReguler updateTiketReguler(@RequestBody TiketReguler tiketReguler) {
        return tiketRegulerService.updateTiketReguler(tiketReguler); // Update the tiketreguler
    }

    // Delete a tiketreguler by ID
    @DeleteMapping("/{id}")
    public void deleteTiketReguler(@PathVariable int id) {
        tiketRegulerService.deleteTiketReguler(id); // Delete the tiketreguler by ID
    }
}
