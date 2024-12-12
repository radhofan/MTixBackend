package com.example.MTIXBackend.service;

import com.example.MTIXBackend.model.TiketReguler;
import com.example.MTIXBackend.repository.TiketRegulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TiketRegulerService {

    private final TiketRegulerRepository tiketRegulerRepository;

    @Autowired
    public TiketRegulerService(TiketRegulerRepository tiketRegulerRepository) {
        this.tiketRegulerRepository = tiketRegulerRepository;
    }

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

    public void deleteTiketReguler(int id) {
        tiketRegulerRepository.deleteById(id); // Delete the user by ID
    }
}
