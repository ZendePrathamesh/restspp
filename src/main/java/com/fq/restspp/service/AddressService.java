package com.fq.restspp.service;

import com.fq.restspp.enitity.Address;
import com.fq.restspp.exception.AddressNotFound;
import com.fq.restspp.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j

public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public Address add(Address address) {
        log.info("adding address");

        Address addedAddress = addressRepository.save(address);

        log.info("adding address completed");
        return addedAddress;
    }

    public Address getAddress(Long id) {
        log.info("fetch address");

        Optional<Address> foundAddress = addressRepository.findById(id);

        log.info("fetch address completed");
        return foundAddress.orElseGet(Address::new);
    }

    public Address updateAddress(Address address) {
        log.info("Update address");

        Address updatedAddress;

        Optional<Address> existingAddress = addressRepository.findById(address.getId());
        if (existingAddress.isPresent()) {
            updatedAddress = addressRepository.save(address);
        } else {
            throw new AddressNotFound("Address with id = " + address.getId() + " is not found");
        }
        log.info("Update address completed");
        return updatedAddress;
    }



    public String deleteAddress(Long id) {
        log.info("delete address");

        Optional<Address> existingAddress = addressRepository.findById(id);
        if (existingAddress.isEmpty()) {
            throw new AddressNotFound("Address with id = " + id + " is not found");
        }
        addressRepository.deleteById(id);

        log.info("delete address completed");
        return "Address deleted";
    }
}