package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.SiteUser;
import com.truthwear.truthwear.repository.SiteUserRepository;
import com.truthwear.truthwear.service.interfaces.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private SiteUserRepository siteUserRepository;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(SiteUserRepository siteUserRepository) {
        this.siteUserRepository = siteUserRepository;
    }
    @Override
    public SiteUser saveUser(SiteUser siteUser) {
        if (siteUserRepository.existsByEmailId(siteUser.getEmailId()))
            throw new RuntimeException("User already exists");
        else
            return siteUserRepository.save(siteUser);
    }

    @Override
    public List<SiteUser> getAllUsers() {
        return siteUserRepository.findAll();
    }

    @Override
    @Transactional
    public SiteUser deleteUser(int id) {
        if (siteUserRepository.existsById(id)) {
            SiteUser siteUser = siteUserRepository.findById(id).get();
            siteUserRepository.deleteById(id);
            return siteUser;
        }
        else
            throw new RuntimeException("User does not exist");
    }

    @Override
    public SiteUser updateUser(int id, SiteUser updatedSiteUser){
        updatedSiteUser.setId(id);
        return siteUserRepository.save(updatedSiteUser);
    }

    @Override
    public ResponseEntity<?> getUserById(int id) {
      if (siteUserRepository.existsById(id)){
         SiteUser siteUser = siteUserRepository.findById(id).get();
         return new ResponseEntity<>(siteUser, HttpStatus.OK);
      }
      else{
          Map<String, String> errorResponse = new HashMap<>();
          errorResponse.put("error", "User not found with id: " + id);
          return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
      }
    }
}
