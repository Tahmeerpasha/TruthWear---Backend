package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.ShoppingCart;
import com.truthwear.truthwear.entity.SiteUser;
import com.truthwear.truthwear.repository.SiteUserRepository;
import com.truthwear.truthwear.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final SiteUserRepository siteUserRepository;

    // Save a new user
    @Override
    public SiteUser saveUser(SiteUser siteUser) {
        if (siteUserRepository.existsByEmailId(siteUser.getEmailId()))
                    throw new RuntimeException("User already exists");
        return siteUserRepository.save(siteUser);

    }

    // Get all users
    @Override
    public List<SiteUser> getAllUsers() {
        return siteUserRepository.findAll();
    }

    // Delete a user by id
    @Override
    public SiteUser deleteUser(int id) {
        Optional<SiteUser> siteUserOptional = siteUserRepository.findById(id);
        if (siteUserOptional.isEmpty()) {
            throw new RuntimeException("User does not exist");
        }
        SiteUser siteUser = siteUserOptional.get();
        siteUserRepository.deleteById(id);
        return siteUser;
    }

    // Update an existing user
    @Override
    public SiteUser updateUser(int id, SiteUser updatedSiteUser) {
        Optional<SiteUser> siteUserOptional = siteUserRepository.findById(id);
        if (siteUserOptional.isEmpty()) {
            throw new RuntimeException("User does not exist");
        }
        updatedSiteUser.setId(id);
        return siteUserRepository.save(updatedSiteUser);
    }

    // Get a specific user by id
    @Override
    public SiteUser getUserById(int id) {
        Optional<SiteUser> siteUserOptional = siteUserRepository.findById(id);
        return siteUserOptional.orElse(null);
    }
}