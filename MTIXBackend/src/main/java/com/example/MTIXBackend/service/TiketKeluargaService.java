package com.example.MTIXBackend.service;

import com.example.MTIXBackend.model.TiketKeluarga;
import com.example.MTIXBackend.repository.TiketKeluargaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class TiketKeluargaService {

    //////////////////////////////////////////////////////// Attributes
    private final TiketKeluargaRepository tiketKeluargaRepository;
    private final MuseumService museumService;

    @Autowired
    public TiketKeluargaService(MuseumService museumService, TiketKeluargaRepository tiketKeluargaRepository) {
        this.museumService = museumService;
        this.tiketKeluargaRepository = tiketKeluargaRepository;
    }

    //////////////////////////////////////////////////////// Continued Business Methods
    public TiketKeluarga createTiket(String nama_keluarga, int jumlah_orang, TiketKeluarga tiketKeluarga) {
        tiketKeluarga.setGroupName(nama_keluarga);
        tiketKeluarga.setGroupCount(jumlah_orang);
        tiketKeluarga.setMuseum(
                museumService.getMuseumById(tiketKeluarga.getKeranjang().getMuseum().getMuseum_id())
        );
        tiketKeluarga.setStatus("Upcoming");
        return tiketKeluargaRepository.save(tiketKeluarga);
    }

    //////////////////////////////////////////////////////// CRUD Methods
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

    public TiketKeluarga updateStatus(int id, String newStatus) {
        TiketKeluarga tiketKeluarga = getTiketKeluargaById(id);
        if (tiketKeluarga != null) {
            tiketKeluarga.setStatus(newStatus);
            return tiketKeluargaRepository.save(tiketKeluarga);
        }
        return null; // Handle case where ticket is not found
    }

    // Get tickets by status
    public List<TiketKeluarga> getTicketsByStatus(String status) {
        return tiketKeluargaRepository.findByStatus(status);
    }

    public void deleteTiketKeluarga(int id) {
        tiketKeluargaRepository.deleteById(id); // Delete the user by ID
    }
}
