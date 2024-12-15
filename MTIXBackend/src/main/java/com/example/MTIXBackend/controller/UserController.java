package com.example.MTIXBackend.controller;

import com.example.MTIXBackend.model.Keranjang;
import com.example.MTIXBackend.service.KeranjangService;
import com.example.MTIXBackend.model.User;
import com.example.MTIXBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users") // Define base URL for User-related operations
public class UserController {

    private final UserService userService;
    //private final KeranjangService keranjangService;

    // Inject UserService into the controller using constructor-based dependency injection
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
//    @Autowired
//    public UserController(UserService userService, KeranjangService keranjangService) {
//        this.userService = userService;
//        this.keranjangService = keranjangService;  // Ensure proper initialization
//    }

    // Endpoint for logging in
    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000")
    public User loginUser(@RequestBody User user) {
        User authenticatedUser = userService.authenticateUser(user.getEmail(), user.getPassword());

        if (authenticatedUser != null) {
            // Return user data or authentication token here (e.g., JWT)
            return authenticatedUser;
        } else {
            throw new RuntimeException("Invalid email or password");
        }
    }

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers(); // Delegate to the service layer
    }

    // Get a user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id); // Get user by ID
    }

    // Create a new user
    @PostMapping("/create")
    @CrossOrigin(origins = "http://localhost:3000")
    public User createUser(@RequestBody User user) {
//        // First create the Keranjang
//        Keranjang newKeranjang = new Keranjang();
//        // Set fields for Keranjang if needed (do not set keranjang_id, let it auto-generate)
//        newKeranjang = keranjangService.createKeranjang(newKeranjang); // Now correctly use the instance
//
//        // Set the keranjang_id in the user object
//        user.setKeranjang(newKeranjang); // Assuming a one-to-one or many-to-one relationship

        // Now create the user with the keranjang_id
        return userService.createUser(user);
    }

    // Update a user by ID
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        user.setUser_id(id); // Set the ID in the user object
        return userService.updateUser(user); // Update the user
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id); // Delete the user by ID
    }
}
