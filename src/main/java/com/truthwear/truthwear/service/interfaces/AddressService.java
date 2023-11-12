package com.truthwear.truthwear.service.interfaces;

import com.truthwear.truthwear.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddress(int id);

    Address createAddress(Address address, int id);

    Address updateAddress(Address address, int id);

    Address deleteAddress(int id);
}
