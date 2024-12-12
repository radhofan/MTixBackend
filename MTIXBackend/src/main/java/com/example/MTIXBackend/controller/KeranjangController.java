package com.example.MTIXBackend.controller;

import com.example.MTIXBackend.model.Keranjang;
import com.example.MTIXBackend.service.KeranjangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/keranjangs") // Define base URL for Keranjang-related operations
public class KeranjangController {

    private final KeranjangService keranjangService;

    // Inject KeranjangService into the controller using constructor-based dependency injection
    @Autowired
    public KeranjangController(KeranjangService keranjangService) {
        this.keranjangService = keranjangService;
    }

    // Get all keranjangs
    @GetMapping
    public List<Keranjang> getAllKeranjangs() {
        return keranjangService.getAllKeranjangs(); // Delegate to the service layer
    }

    // Get a keranjang by ID
    @GetMapping("/{id}")
    public Keranjang getKeranjangById(@PathVariable int id) {
        return keranjangService.getKeranjangById(id); // Get keranjang by ID
    }

    // Create a new keranjang
    @PostMapping
    public Keranjang createKeranjang(@RequestBody Keranjang keranjang) {
        return keranjangService.createKeranjang(keranjang); // Delegate to service for creating the keranjang
    }

    // Update a keranjang
    @PutMapping
    public Keranjang updateKeranjang(@RequestBody Keranjang keranjang) {
        return keranjangService.updateKeranjang(keranjang); // Update the keranjang
    }

    // Delete a keranjang by ID
    @DeleteMapping("/{id}")
    public void deleteKeranjang(@PathVariable int id) {
        keranjangService.deleteKeranjang(id); // Delete the keranjang by ID
    }
}
