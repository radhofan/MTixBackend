package com.example.MTIXBackend.service;

import com.example.MTIXBackend.model.User;
import com.example.MTIXBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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

    // Method to authenticate user based on email and password
    public User authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email);  // Assuming you have a method in your repository to find user by email
        if (user != null && user.getPassword().equals(password)) {  // Simple password check (consider hashing in production)
            return user;
        }
        return null; // Return null if credentials don't match
    }
}
