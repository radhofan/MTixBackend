package com.example.MTIXBackend.controller;

import com.example.MTIXBackend.model.Keranjang;
import com.example.MTIXBackend.service.KeranjangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/keranjangs")
public class KeranjangController {

    //////////////////////////////////////////////////////// Attributes and Contructors
    private final KeranjangService keranjangService;

    @Autowired
    public KeranjangController(KeranjangService keranjangService) {
        this.keranjangService = keranjangService;
    }

    //////////////////////////////////////////////////////// Business Methods
    @PostMapping("/createKeranjang")
    public Keranjang createKeranjangUser(@RequestBody Keranjang keranjang) {
        return keranjangService.createKeranjang(keranjang);
    }

    @GetMapping("/getKeranjang/{userId}")
    public Keranjang getKeranjangUser(@PathVariable int userId) {
        return keranjangService.getKeranjangForUser(userId);
    }

    @PutMapping("/updateKeranjang/{userId}")
    public Keranjang updateKeranjangUser(@PathVariable int userId, @RequestBody Keranjang updatedKeranjang) {
        return keranjangService.updateKeranjangForUser(userId, updatedKeranjang);
    }

    //////////////////////////////////////////////////////// CRUD Methods
    // Get all keranjangs
    @GetMapping
    public List<Keranjang> getAllKeranjangs() {
        return keranjangService.getAllKeranjangs();
    }

    // Get a keranjang by ID
    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Keranjang getKeranjangById(@PathVariable int id) {
        return keranjangService.getKeranjangById(id);
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
        return keranjangService.updateKeranjang(keranjang);
    }

    // Delete a keranjang by ID
    @DeleteMapping("/{id}")
    public void deleteKeranjang(@PathVariable int id) {
        keranjangService.deleteKeranjang(id);
    }
}
