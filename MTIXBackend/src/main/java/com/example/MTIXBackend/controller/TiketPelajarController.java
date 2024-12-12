package com.example.MTIXBackend.controller;

import com.example.MTIXBackend.model.TiketPelajar;
import com.example.MTIXBackend.service.TiketPelajarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiketpelajars") // Define base URL for TiketPelajar-related operations
public class TiketPelajarController {

    private final TiketPelajarService tiketPelajarService;

    // Inject TiketPelajarService into the controller using constructor-based dependency injection
    @Autowired
    public TiketPelajarController(TiketPelajarService tiketPelajarService) {
        this.tiketPelajarService = tiketPelajarService;
    }

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

    // Update a tiketpelajar
    @PutMapping
    public TiketPelajar updateTiketPelajar(@RequestBody TiketPelajar tiketPelajar) {
        return tiketPelajarService.updateTiketPelajar(tiketPelajar); // Update the tiketpelajar
    }

    // Delete a tiketpelajar by ID
    @DeleteMapping("/{id}")
    public void deleteTiketPelajar(@PathVariable int id) {
        tiketPelajarService.deleteTiketPelajar(id); // Delete the tiketpelajar by ID
    }
}