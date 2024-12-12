package com.example.MTIXBackend.controller;

import com.example.MTIXBackend.model.Museum;
import com.example.MTIXBackend.service.MuseumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/museums") // Define base URL for Museum-related operations
public class MuseumController {

    private final MuseumService museumService;

    // Inject MuseumService into the controller using constructor-based dependency injection
    @Autowired
    public MuseumController(MuseumService museumService) {
        this.museumService = museumService;
    }

    // Get all museums
    @GetMapping
    public List<Museum> getAllMuseums() {
        return museumService.getAllMuseums(); // Delegate to the service layer
    }

    // Get a museum by ID
    @GetMapping("/{id}")
    public Museum getMuseumById(@PathVariable int id) {
        return museumService.getMuseumById(id); // Get museum by ID
    }

    // Create a new museum
    @PostMapping
    public Museum createMuseum(@RequestBody Museum museum) {
        return museumService.createMuseum(museum); // Delegate to service for creating the museum
    }

    // Update a museum by ID
    @PutMapping("/{id}")
    public Museum updateMuseum(@PathVariable int id, @RequestBody Museum museum) {
        museum.setMuseum_id(id); // Set the ID in the museum object
        return museumService.updateMuseum(museum); // Update the museum
    }

    // Delete a museum by ID
    @DeleteMapping("/{id}")
    public void deleteMuseum(@PathVariable int id) {
        museumService.deleteMuseum(id); // Delete the museum by ID
    }
}
