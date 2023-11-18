package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.SiteUser;
import com.truthwear.truthwear.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    // Create a new user
    @PostMapping
    public ResponseEntity<SiteUser> saveUser(@RequestBody SiteUser siteUser) {
        try {
            SiteUser createdUser = userService.saveUser(siteUser);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get all users
    @GetMapping
    public ResponseEntity<List<SiteUser>> getAllUsers() {
        try {
            List<SiteUser> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get a specific user by id
    @GetMapping("/{id}")
    public ResponseEntity<SiteUser> getUserById(@PathVariable int id) {
        try {
            SiteUser user = userService.getUserById(id);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete a user by id
    @DeleteMapping("/{id}")
    public ResponseEntity<SiteUser> deleteUser(@PathVariable int id) {
        try {
            SiteUser deletedUser = userService.deleteUser(id);
            return ResponseEntity.ok(deletedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Update an existing user
    @PutMapping("/{id}")
    public ResponseEntity<SiteUser> updateUser(@PathVariable int id, @RequestBody SiteUser siteUser) {
        try {
            SiteUser updatedUser = userService.updateUser(id, siteUser);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}