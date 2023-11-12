package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.User;
import com.truthwear.truthwear.repository.UserRepository;
import com.truthwear.truthwear.service.interfaces.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User saveUser(User user) {
        if (userRepository.existsByEmailId(user.getEmailId()))
            throw new RuntimeException("User already exists");
        else
            return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User deleteUser(int id) {
        if (userRepository.existsById(id)) {
            User user = userRepository.findById(id).get();
            userRepository.deleteById(id);
            return user;
        }
        else
            throw new RuntimeException("User does not exist");
    }

    @Override
    public User updateUser(int id, User updatedUser){
        updatedUser.setId(id);
        return userRepository.save(updatedUser);
    }

    @Override
    public ResponseEntity<?> getUserById(int id) {
      if (userRepository.existsById(id)){
         User user = userRepository.findById(id).get();
         return new ResponseEntity<>(user, HttpStatus.OK);
      }
      else{
          Map<String, String> errorResponse = new HashMap<>();
          errorResponse.put("error", "User not found with id: " + id);
          return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
      }
    }
}
