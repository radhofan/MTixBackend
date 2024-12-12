package com.example.MTIXBackend.service;

import com.example.MTIXBackend.model.Keranjang;
import com.example.MTIXBackend.repository.KeranjangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KeranjangService {

    private final KeranjangRepository keranjangRepository;

    @Autowired
    public KeranjangService(KeranjangRepository keranjangRepository) {
        this.keranjangRepository = keranjangRepository;
    }

    public List<Keranjang> getAllKeranjangs() {
        return keranjangRepository.findAll();
    }

    public Keranjang getKeranjangById(int id) {
        Optional<Keranjang> keranjang = keranjangRepository.findById(id);
        return keranjang.orElse(null); // Return the user if found, else return null
    }

    public Keranjang createKeranjang(Keranjang keranjang) {
        return keranjangRepository.save(keranjang); // Save the new user to the database
    }

    public Keranjang updateKeranjang(Keranjang keranjang) {
        return keranjangRepository.save(keranjang); // Save the updated user to the database
    }

    public void deleteKeranjang(int id) {
        keranjangRepository.deleteById(id); // Delete the user by ID
    }
}
