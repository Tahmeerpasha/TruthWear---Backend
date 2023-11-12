package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.Address;
import com.truthwear.truthwear.service.AddressServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {

    private final AddressServiceImpl addressService;

    public AddressController(AddressServiceImpl addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/addresses/{id}")
    public List<Address> getAllAddress(@PathVariable int id){
        return addressService.getAllAddress(id);
    }

    @PostMapping("/addresses/{id}")
    public Address createAddress(@RequestBody Address address, @PathVariable int id){
        Address returnedAddress = addressService.createAddress(address, id);

        if (returnedAddress == null) throw new RuntimeException("User not found");

        return returnedAddress;
    }

    @PutMapping("/addresses/{id}")
    public Address updateAddress(@RequestBody Address address, @PathVariable int id){
        Address returnedAddress = addressService.updateAddress(address, id);

        if (returnedAddress == null) throw new RuntimeException("User not found");

        return returnedAddress;
    }

    @DeleteMapping("/addresses/{id}")
    public Address deleteAddress(@PathVariable int id){
       return addressService.deleteAddress(id);
    }
}
