package com.example.MTIXBackend.service;

import com.example.MTIXBackend.model.TiketPelajar;
import com.example.MTIXBackend.repository.TiketPelajarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TiketPelajarService {

    private final TiketPelajarRepository tiketPelajarRepository;

    @Autowired
    public TiketPelajarService(TiketPelajarRepository tiketPelajarRepository) {
        this.tiketPelajarRepository = tiketPelajarRepository;
    }

    public List<TiketPelajar> getAllTiketPelajars() {
        return tiketPelajarRepository.findAll();
    }

    public TiketPelajar getTiketPelajarById(int id) {
        Optional<TiketPelajar> admin = tiketPelajarRepository.findById(id);
        return admin.orElse(null); // Return the user if found, else return null
    }

    public TiketPelajar createTiketPelajar(TiketPelajar tiketPelajar) {
        return tiketPelajarRepository.save(tiketPelajar); // Save the new user to the database
    }

    public TiketPelajar updateTiketPelajar(TiketPelajar tiketPelajar) {
        return tiketPelajarRepository.save(tiketPelajar); // Save the updated user to the database
    }

    public void deleteTiketPelajar(int id) {
        tiketPelajarRepository.deleteById(id); // Delete the user by ID
    }
}
