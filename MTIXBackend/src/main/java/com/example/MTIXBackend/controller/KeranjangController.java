package com.example.MTIXBackend.controller;

import com.example.MTIXBackend.model.Keranjang;
import com.example.MTIXBackend.service.KeranjangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/keranjangs") // Define base URL for Keranjang-related operations
public class KeranjangController {

    //////////////////////////////////////////////////////// Attributes and Contructors
    private final KeranjangService keranjangService;

    @Autowired
    public KeranjangController(KeranjangService keranjangService) {
        this.keranjangService = keranjangService;
    }

    //////////////////////////////////////////////////////// Business Methods
    @PostMapping("/createKeranjang")
    @CrossOrigin(origins = "http://localhost:3000")
    public Keranjang createKeranjangUser(@RequestBody Keranjang keranjang) {
        return keranjangService.createKeranjang(keranjang);
    }

    @GetMapping("/getKeranjang/{userId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Keranjang getKeranjangUser(@PathVariable int userId) {
        return keranjangService.getKeranjangForUser(userId); // Call the service to get the Keranjang
    }

    @PutMapping("/updateKeranjang/{userId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Keranjang updateKeranjangUser(@PathVariable int userId, @RequestBody Keranjang updatedKeranjang) {
        return keranjangService.updateKeranjangForUser(userId, updatedKeranjang); // Call the service to update the Keranjang
    }

    //////////////////////////////////////////////////////// CRUD Methods
    // Get all keranjangs
    @GetMapping
    public List<Keranjang> getAllKeranjangs() {
        return keranjangService.getAllKeranjangs(); // Delegate to the service layer
    }

    // Get a keranjang by ID
    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Keranjang getKeranjangById(@PathVariable int id) {
        return keranjangService.getKeranjangById(id); // Get keranjang by ID
    }

    // Create a new keranjang
    @PostMapping
    public Keranjang createKeranjang(@RequestBody Keranjang keranjang) {
        return keranjangService.createKeranjang(keranjang);
    }

    // Update a keranjang
    @PutMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public Keranjang updateKeranjang(@RequestBody Keranjang keranjang) {
        return keranjangService.updateKeranjang(keranjang); // Update the keranjang
    }

    // Delete a keranjang by ID
    @DeleteMapping("/{id}")
    public void deleteKeranjang(@PathVariable int id) {
        keranjangService.deleteKeranjang(id); // Delete the keranjang by ID
    }
}
