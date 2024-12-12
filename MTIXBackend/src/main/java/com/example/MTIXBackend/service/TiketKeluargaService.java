package com.example.MTIXBackend.service;

import com.example.MTIXBackend.model.TiketKeluarga;
import com.example.MTIXBackend.repository.TiketKeluargaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TiketKeluargaService {

    private final TiketKeluargaRepository tiketKeluargaRepository;

    @Autowired
    public TiketKeluargaService(TiketKeluargaRepository tiketKeluargaRepository) {
        this.tiketKeluargaRepository = tiketKeluargaRepository;
    }

    public List<TiketKeluarga> getAllTiketKeluargas() {
        return tiketKeluargaRepository.findAll();
    }

    public TiketKeluarga getTiketKeluargaById(int id) {
        Optional<TiketKeluarga> admin = tiketKeluargaRepository.findById(id);
        return admin.orElse(null); // Return the user if found, else return null
    }

    public TiketKeluarga createTiketKeluarga(TiketKeluarga tiketKeluarga) {
        return tiketKeluargaRepository.save(tiketKeluarga); // Save the new user to the database
    }

    public TiketKeluarga updateTiketKeluarga(TiketKeluarga tiketKeluarga) {
        return tiketKeluargaRepository.save(tiketKeluarga); // Save the updated user to the database
    }

    public void deleteTiketKeluarga(int id) {
        tiketKeluargaRepository.deleteById(id); // Delete the user by ID
    }
}
