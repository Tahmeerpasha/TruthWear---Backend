package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
     User saveUser(User user);

     List<User> getAllUsers();

     User deleteUser(int id);

     User updateUser(int id, User user);

     ResponseEntity<?> getUserById(int id);
}
