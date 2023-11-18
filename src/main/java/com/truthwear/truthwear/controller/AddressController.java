package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.Address;
import com.truthwear.truthwear.service.AddressServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressServiceImpl addressService;

//    Get all addresses of a specific user by userId
    @GetMapping("/{userId}")
    public ResponseEntity<List<Address>> getAllAddresses(@PathVariable int userId) {
        try {
            List<Address> addresses = addressService.getAllAddresses(userId);
            return ResponseEntity.ok(addresses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

//    Create a new address for a specific user by userId
    @PostMapping("/{userId}")
    public ResponseEntity<Address> createAddress(@RequestBody Address address, @PathVariable int userId) {
        try {
            Address returnedAddress = addressService.createAddress(address, userId);
            return ResponseEntity.status(HttpStatus.CREATED).body(returnedAddress);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

//    Update address by addressId
    @PutMapping("/{addressId}")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address, @PathVariable int addressId) {
        try {
            Address returnedAddress = addressService.updateAddress(address, addressId);
            return ResponseEntity.ok(returnedAddress);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

//    Delete address by addressId
    @DeleteMapping("/{addressId}")
    public ResponseEntity<Address> deleteAddress(@PathVariable int addressId) {
        try {
            Address deletedAddress = addressService.deleteAddress(addressId);
            return ResponseEntity.ok(deletedAddress);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
