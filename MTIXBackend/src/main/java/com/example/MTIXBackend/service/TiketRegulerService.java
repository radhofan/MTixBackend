package com.example.MTIXBackend.service;

import com.example.MTIXBackend.model.TiketPelajar;
import com.example.MTIXBackend.model.TiketReguler;
import com.example.MTIXBackend.repository.TiketRegulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TiketRegulerService {

    //////////////////////////////////////////////////////// Attributes
    private final TiketRegulerRepository tiketRegulerRepository;
    private final MuseumService museumService;

    @Autowired
    public TiketRegulerService(TiketRegulerRepository tiketRegulerRepository, MuseumService museumService) {
        this.tiketRegulerRepository = tiketRegulerRepository;
        this.museumService = museumService;
    }

    //////////////////////////////////////////////////////// Business Methods
    public TiketReguler createTiket(TiketReguler tiketReguler) {
        tiketReguler.setMuseum(
                museumService.getMuseumById(tiketReguler.getKeranjang().getMuseum().getMuseum_id())
        );
        tiketReguler.setStatus("Upcoming");
        return tiketRegulerRepository.save(tiketReguler);
    }

    //////////////////////////////////////////////////////// CRUD Methods
    public List<TiketReguler> getAllTiketRegulers() {
        return tiketRegulerRepository.findAll();
    }

    public TiketReguler getTiketRegulerById(int id) {
        Optional<TiketReguler> admin = tiketRegulerRepository.findById(id);
        return admin.orElse(null); // Return the user if found, else return null
    }

    public TiketReguler createTiketReguler(TiketReguler tiketReguler) {
        return tiketRegulerRepository.save(tiketReguler); // Save the new user to the database
    }

    public TiketReguler updateTiketReguler(TiketReguler tiketReguler) {
        return tiketRegulerRepository.save(tiketReguler); // Save the updated user to the database
    }

    // New method to update the status
    public TiketReguler updateStatus(int id, String newStatus) {
        TiketReguler tiketReguler = getTiketRegulerById(id);
        if (tiketReguler != null) {
            tiketReguler.setStatus(newStatus);
            return tiketRegulerRepository.save(tiketReguler);
        }
        return null; // Return null if ticket not found
    }

    // Custom method to get TiketReguler by status
    public List<TiketReguler> getTiketRegulersByStatus(String status) {
        return tiketRegulerRepository.findByStatus(status);
    }

    public void deleteTiketReguler(int id) {
        tiketRegulerRepository.deleteById(id); // Delete the user by ID
    }
}
