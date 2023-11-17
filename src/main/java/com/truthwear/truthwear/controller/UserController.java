package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.SiteUser;
import com.truthwear.truthwear.service.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("users")
    public SiteUser saveUser(@RequestBody SiteUser siteUser) {
        return userService.saveUser(siteUser);
    }

    @GetMapping("users")
    public List<SiteUser> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("users/{id}")
    public ResponseEntity<?> getUserById1(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("users/{id}")
    public SiteUser deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    //This is not implemented yet.
    @PutMapping("users/{id}")
    public SiteUser updateUser(@PathVariable int id, @RequestBody SiteUser siteUser) {
        return userService.updateUser(id, siteUser);
    }
}
