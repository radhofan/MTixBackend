package com.example.MTIXBackend.service;

import com.example.MTIXBackend.model.Keranjang;
import com.example.MTIXBackend.model.Museum;
import com.example.MTIXBackend.repository.KeranjangRepository;
import com.example.MTIXBackend.repository.MuseumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KeranjangService {

    private final KeranjangRepository keranjangRepository;
    @Autowired
    private MuseumRepository museumRepository;

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
        if (keranjang.getMuseum() == null) {
            // Fetch the default Museum from the database
            Museum defaultMuseum = museumRepository.findById(1).orElseThrow(() ->
                    new RuntimeException("Default Museum not found!")
            );
            keranjang.setMuseum(defaultMuseum);
        }

        // Save the Keranjang object to the database
        return keranjangRepository.save(keranjang);
    }

    public Keranjang updateKeranjang(Keranjang keranjang) {
        return keranjangRepository.save(keranjang); // Save the updated user to the database
    }

    public void deleteKeranjang(int id) {
        keranjangRepository.deleteById(id); // Delete the user by ID
    }
}
