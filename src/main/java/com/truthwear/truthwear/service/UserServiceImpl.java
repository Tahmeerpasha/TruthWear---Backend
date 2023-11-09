package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.User;
import com.truthwear.truthwear.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService{
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
//        Optional<User> existingUserOptional = userRepository.findById(id);
//
//        if (existingUserOptional.isPresent()) {
//            User existingUser = existingUserOptional.get();
//
//            // Update only the fields that should be modified
//            existingUser.setFirstName(updatedUser.getFirstName());
//            existingUser.setLastName(updatedUser.getLastName());
//            existingUser.setEmailId(updatedUser.getEmailId());
//            existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
//            existingUser.setPassword(updatedUser.getPassword());
//            // Update other fields as needed
//
//            // Save the updated user
//            userRepository.save(existingUser);
//
//            return existingUser;
//        } else {
//            // Handle the case where the user with the given ID does not exist
//            throw new RuntimeException("User not found with ID: " + id);
//        }
return null;
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
