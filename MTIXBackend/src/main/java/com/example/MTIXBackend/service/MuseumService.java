package com.example.MTIXBackend.service;

import com.example.MTIXBackend.model.Museum;
import com.example.MTIXBackend.repository.MuseumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuseumService {

    private final MuseumRepository museumRepository;

    @Autowired
    public MuseumService(MuseumRepository museumRepository) {
        this.museumRepository = museumRepository;
    }

    public List<Museum> getAllMuseums() {
        return museumRepository.findAll();
    }

    public Museum getMuseumById(int id) {
        Optional<Museum> museum = museumRepository.findById(id);
        return museum.orElse(null); // Return the user if found, else return null
    }

    public Museum createMuseum(Museum museum) {
        return museumRepository.save(museum); // Save the new user to the database
    }

    public Museum updateMuseum(Museum museum) {
        return museumRepository.save(museum); // Save the updated user to the database
    }

    public void deleteMuseum(int id) {
        museumRepository.deleteById(id); // Delete the user by ID
    }
}
