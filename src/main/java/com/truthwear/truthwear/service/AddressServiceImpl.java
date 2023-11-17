package com.truthwear.truthwear.service;

import com.truthwear.truthwear.entity.Address;
import com.truthwear.truthwear.entity.SiteUser;
import com.truthwear.truthwear.entity.UserAddress;
import com.truthwear.truthwear.repository.AddressRepository;
import com.truthwear.truthwear.repository.UserAddressRepository;
import com.truthwear.truthwear.repository.SiteUserRepository;
import com.truthwear.truthwear.service.interfaces.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;
    private SiteUserRepository siteUserRepository;

    private UserAddressRepository userAddressRepository;
    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, SiteUserRepository siteUserRepository, UserAddressRepository userAddressRepository) {
        this.addressRepository = addressRepository;
        this.siteUserRepository = siteUserRepository;
        this.userAddressRepository = userAddressRepository;
    }
    @Override
    public List<Address> getAllAddress(int id) {
        List<UserAddress> userAddress;
        List<Address> addresses = new ArrayList<>();
        try {
            userAddress = userAddressRepository.findByUserId(id);
            userAddress.stream().map(userAddress1 -> addressRepository.findById(userAddress1.getAddressId()).get())
                    .forEach(address -> addresses.add(address));
        }catch (NoSuchElementException e){
            System.out.println(e);
            return null;
        }
        return addresses;
    }

    @Override
    public Address createAddress(Address address, int id) {
        SiteUser siteUser;
        try {
            siteUser = siteUserRepository.findById(id).get();
        }catch (NoSuchElementException e){
            System.out.println(e);
            return null;
        }
        Address newAddress = addressRepository.save(address);
        UserAddress userAddress = new UserAddress(siteUser.getId(), newAddress.getId(),0);
        userAddressRepository.save(userAddress);
        return newAddress;
    }

    @Override
    public Address updateAddress(Address address, int id) {
        address.setId(id);
        return addressRepository.save(address);
    }

    @Override
    public Address deleteAddress(int id) {
//        First delete entry in user-address table then delete address, to ensure referential integrity
        UserAddress userAddress = userAddressRepository.findByAddressId(id);
        userAddressRepository.delete(userAddress);
        System.out.println(userAddress);

        Address address = addressRepository.findById(id).get();
        addressRepository.delete(address);
        System.out.println(address);

        return address;
    }
}
