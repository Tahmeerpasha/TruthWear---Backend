package com.truthwear.truthwear.service.interfaces;

import com.truthwear.truthwear.entity.SiteUser;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
     SiteUser saveUser(SiteUser siteUser);

     List<SiteUser> getAllUsers();

     SiteUser deleteUser(int id);

     SiteUser updateUser(int id, SiteUser siteUser);

     SiteUser getUserById(int id);
}
