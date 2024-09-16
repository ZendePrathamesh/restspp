package com.fq.restspp.controller;

import com.fq.restspp.enitity.Address;
import com.fq.restspp.service.AddressService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable @Positive Long id) {
        log.info("get address");

        Address address = addressService.getAddress(id);

        log.info("get address completed");
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Address> addAddress(@RequestBody @Valid Address address) {
        log.info("adding address");

        Address newAddress = addressService.add(address);

        log.info("adding address completed");
        return new ResponseEntity<>(newAddress, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody @Valid Address address) {
        log.info("update address for id = {}", id);

        address.setId(id);

        Address updatedAddress = addressService.updateAddress(address);

        log.info("update address completed");
        return new ResponseEntity<>(updatedAddress, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable @Positive Long id) {
        log.info("delete address");

        String message = addressService.deleteAddress(id);

        log.info("delete address completed");
        return new ResponseEntity<>(message, HttpStatus.NO_CONTENT);
    }
}