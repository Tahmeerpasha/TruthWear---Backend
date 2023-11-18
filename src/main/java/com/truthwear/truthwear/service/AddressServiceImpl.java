package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.Address;
import com.truthwear.truthwear.entity.SiteUser;
import com.truthwear.truthwear.entity.UserAddress;
import com.truthwear.truthwear.repository.AddressRepository;
import com.truthwear.truthwear.repository.UserAddressRepository;
import com.truthwear.truthwear.repository.SiteUserRepository;
import com.truthwear.truthwear.service.interfaces.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final SiteUserRepository siteUserRepository;
    private final UserAddressRepository userAddressRepository;

    // Get all addresses for a user
    @Override
    public List<Address> getAllAddresses(int id) {
        List<UserAddress> userAddress;
        List<Address> addresses = new ArrayList<>();
        userAddress = userAddressRepository.findByUserId(id);
        userAddress.stream().map(userAddress1 -> addressRepository.findById(userAddress1.getId()).orElse(null))
                .forEach(addresses::add);
        return addresses;
    }

    // Create a new address for a user
    @Override
    public Address createAddress(Address address, int id) {
        Optional<SiteUser> siteUserOptional = siteUserRepository.findById(id);
        if (siteUserOptional.isEmpty()) {
            return null;
        }
        SiteUser siteUser = siteUserOptional.get();
        Address newAddress = addressRepository.save(address);
        UserAddress userAddress = new UserAddress(siteUser, newAddress,0);
        userAddressRepository.save(userAddress);
        return newAddress;
    }

    // Update an existing address
    @Override
    public Address updateAddress(Address address, int id) {
        address.setId(id);
        return addressRepository.save(address);
    }

    // Delete an address
    @Override
    public Address deleteAddress(int id) {
        Optional<UserAddress> userAddressOptional = Optional.ofNullable(userAddressRepository.findByAddressId(id));
        if (userAddressOptional.isEmpty()) {
            return null;
        }
        UserAddress userAddress = userAddressOptional.get();
        userAddressRepository.delete(userAddress);

        Optional<Address> addressOptional = addressRepository.findById(id);
        if (addressOptional.isEmpty()) {
            return null;
        }
        Address address = addressOptional.get();
        addressRepository.delete(address);
        return address;
    }
}