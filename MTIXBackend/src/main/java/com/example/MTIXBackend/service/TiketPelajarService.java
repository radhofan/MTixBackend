package com.example.MTIXBackend.service;

import com.example.MTIXBackend.model.TiketKeluarga;
import com.example.MTIXBackend.model.TiketPelajar;
import com.example.MTIXBackend.repository.TiketPelajarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TiketPelajarService {

    //////////////////////////////////////////////////////// Attributes
    private final TiketPelajarRepository tiketPelajarRepository;
    private final MuseumService museumService;

    @Autowired
    public TiketPelajarService(TiketPelajarRepository tiketPelajarRepository, MuseumService museumService) {
        this.tiketPelajarRepository = tiketPelajarRepository;
        this.museumService = museumService;
    }

    //////////////////////////////////////////////////////// Continued Business Methods
    public TiketPelajar createTiket(String nama_sekolah, int jumlah_orang, TiketPelajar tiketPelajar) {
        tiketPelajar.setGroupName(nama_sekolah);
        tiketPelajar.setGroupCount(jumlah_orang);
        tiketPelajar.setMuseum(
                museumService.getMuseumById(tiketPelajar.getKeranjang().getMuseum().getMuseum_id())
        );
        tiketPelajar.setStatus("Upcoming");
        return tiketPelajarRepository.save(tiketPelajar);
    }

    //////////////////////////////////////////////////////// CRUD Methods
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

    // Method to filter TiketPelajar by status
    public List<TiketPelajar> getTiketPelajarsByStatus(String status) {
        return tiketPelajarRepository.findByStatus(status);
    }

    public void deleteTiketPelajar(int id) {
        tiketPelajarRepository.deleteById(id); // Delete the user by ID
    }
}
