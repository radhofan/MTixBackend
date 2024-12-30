package com.example.MTIXBackend.controller;

import com.example.MTIXBackend.model.Museum;
import com.example.MTIXBackend.service.MuseumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/museums")
public class MuseumController {

    /// ///////////////////////////////////////////////////// Attributes and Contructors
    private final MuseumService museumService;

    @Autowired
    public MuseumController(MuseumService museumService) {
        this.museumService = museumService;
    }

    //////////////////////////////////////////////////////// Business Methods
    @GetMapping("/getAll")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Museum> viewAllDetails() {
        return museumService.getAllMuseums();
    }

    @PostMapping("/getSpec")
    @CrossOrigin(origins = "http://localhost:3000")
    public Museum viewSpecDetails(@RequestBody Map<String, Integer> requestBody) {
        Integer id = requestBody.get("id");
        return museumService.getMuseumById(id);
    }

    //////////////////////////////////////////////////////// CRUD Methods
    // Get all museums
    @GetMapping("/get")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Museum> getAllMuseums() {
        return museumService.getAllMuseums();
    }

    // Get a museum by ID
    @GetMapping("/get/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Museum getMuseumById(@PathVariable int id) {
        return museumService.getMuseumById(id);
    }

    // Create a new museum
    @PostMapping("/create")
    @CrossOrigin(origins = "http://localhost:3000")
    public Museum createMuseum(@RequestBody Museum museum) {
        return museumService.createMuseum(museum);
    }

    // Update a museum by ID
    @PutMapping("/update/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Museum updateMuseum(@PathVariable int id, @RequestBody Museum museum) {
        museum.setMuseum_id(id);
        return museumService.updateMuseum(museum);
    }

    // Delete a museum by ID
    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteMuseum(@PathVariable int id) {
        museumService.deleteMuseum(id);
    }
}
