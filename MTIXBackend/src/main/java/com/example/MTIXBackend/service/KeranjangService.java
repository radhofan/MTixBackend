package com.example.MTIXBackend.service;

import com.example.MTIXBackend.controller.MuseumController;
import com.example.MTIXBackend.model.Keranjang;
import com.example.MTIXBackend.model.Museum;
import com.example.MTIXBackend.model.User;
import com.example.MTIXBackend.repository.KeranjangRepository;
import com.example.MTIXBackend.repository.MuseumRepository;
import com.example.MTIXBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class KeranjangService {

    //////////////////////////////////////////////////////// Attributes and Contructors
    @Autowired
    private MuseumController museumController;
    private final MuseumRepository museumRepository;
    private final KeranjangRepository keranjangRepository;
    private final UserRepository userRepository;

    @Autowired
    public KeranjangService(KeranjangRepository keranjangRepository, UserRepository userRepository, MuseumRepository museumRepository, MuseumController museumController) {
        this.keranjangRepository = keranjangRepository;
        this.userRepository = userRepository;
        this.museumRepository = museumRepository;
        this.museumController = museumController;
    }

    //////////////////////////////////////////////////////// Continued Business Methods
    public Keranjang getKeranjangForUser(int userId) {
        User user = userRepository.findById(userId).orElse(null); // Find the user by ID
        if (user != null) {
            return user.viewKeranjang();  // Call the viewKeranjang method and return the Keranjang object
        } else {
            // Handle user not found
            throw new RuntimeException("User not found with ID: " + userId);
        }
    }

    public Keranjang updateKeranjangForUser(int userId, Keranjang updatedKeranjang) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
        Keranjang currentKeranjang = user.getKeranjang();
        if (currentKeranjang != null) {
            currentKeranjang.setJumlah_tiket(updatedKeranjang.getJumlah_tiket());
            currentKeranjang.setJenis_tiket(updatedKeranjang.getJenis_tiket());
            currentKeranjang.setMuseum(updatedKeranjang.getMuseum());

            Integer museumId = currentKeranjang.getMuseum().getMuseum_id();
            Map<String, Integer> requestBody = new HashMap<>();
            requestBody.put("id", museumId);
            Museum museum = museumController.viewSpecDetails(requestBody);
            double price = 0;
            if(currentKeranjang.getJenis_tiket().equals("Tiket Reguler")){
                price = museum.getTiket_reguler_price();
            }else if(currentKeranjang.getJenis_tiket().equals("Tiket Pelajar")){
                price = museum.getTiket_pelajar_price();
            }
            else if(currentKeranjang.getJenis_tiket().equals("Tiket Keluarga")){
                price = museum.getTiket_keluarga_price();
            }
            currentKeranjang.setTotal_harga(currentKeranjang.getJumlah_tiket() * price);
            keranjangRepository.save(currentKeranjang);
        } else {
            throw new RuntimeException("Keranjang not found for user with ID: " + userId);
        }

        return currentKeranjang;
    }
    //////////////////////////////////////////////////////// CRUD Methods
    public List<Keranjang> getAllKeranjangs() {
        return keranjangRepository.findAll();
    }

    public Keranjang getKeranjangById(int id) {
        Optional<Keranjang> keranjang = keranjangRepository.findById(id);
        return keranjang.orElse(null); // Return the user if found, else return null
    }

    public Keranjang createKeranjang(Keranjang keranjang) {
        if (keranjang.getMuseum() == null) {
            Museum defaultMuseum = museumRepository.findById(1).orElseThrow(() ->
                    new RuntimeException("Default Museum not found!")
            );
            keranjang.setMuseum(defaultMuseum);
        }

        return keranjangRepository.save(keranjang);
    }

    public Keranjang updateKeranjang(Keranjang keranjang) {
        return keranjangRepository.save(keranjang); // Save the updated user to the database
    }

    public void deleteKeranjang(int id) {
        keranjangRepository.deleteById(id); // Delete the user by ID
    }
}
