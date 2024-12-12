package com.example.MTIXBackend.controller;

import com.example.MTIXBackend.model.Admin;
import com.example.MTIXBackend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins") // Define base URL for Admin-related operations
public class AdminController {

    private final AdminService adminService;

    // Inject AdminService into the controller using constructor-based dependency injection
    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Get all admins
    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins(); // Delegate to the service layer
    }

    // Get an admin by ID
    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable int id) {
        return adminService.getAdminById(id); // Get admin by ID
    }

    // Create a new admin
    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.createAdmin(admin); // Delegate to service for creating the admin
    }

    // Update an admin by ID
    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable int id, @RequestBody Admin admin) {
        admin.setAdmin_id(id); // Set the ID in the admin object
        return adminService.updateAdmin(admin); // Update the admin
    }

    // Delete an admin by ID
    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable int id) {
        adminService.deleteAdmin(id); // Delete the admin by ID
    }
}
