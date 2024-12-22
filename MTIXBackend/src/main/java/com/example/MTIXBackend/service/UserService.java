package com.example.MTIXBackend.service;

import com.example.MTIXBackend.model.Keranjang;
import com.example.MTIXBackend.model.User;
import com.example.MTIXBackend.repository.KeranjangRepository;
import com.example.MTIXBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    //////////////////////////////////////////////////////// Attributes and Contructors
    ///
    private final UserRepository userRepository;
    private final KeranjangRepository keranjangRepository;

    @Autowired
    public UserService(UserRepository userRepository, KeranjangRepository keranjangRepository) {
        this.userRepository = userRepository;
        this.keranjangRepository = keranjangRepository;
    }

    //////////////////////////////////////////////////////// Continued Business Methods
    public User authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email);  // Find user by email

        if (user != null && user.getPassword().equals(password)) {  // Check if the password matches
            // Remove the reference to Keranjang before returning the User object
            user.setKeranjang(null);
            return user;  // Return the User object without Keranjang
        }

        throw new RuntimeException("Invalid email or password");  // Throw an exception for invalid credentials
    }

    //////////////////////////////////////////////////////// CRUD Methods
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null); // Return the user if found, else return null
    }

    public User createUser(User user) {
        return userRepository.save(user); // Save the new user to the database
    }

    public User updateUser(User user) {
        return userRepository.save(user); // Save the updated user to the database
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id); // Delete the user by ID
    }

}
