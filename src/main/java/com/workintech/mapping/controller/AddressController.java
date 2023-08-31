package com.workintech.mapping.controller;

import com.workintech.mapping.entity.Address;
import com.workintech.mapping.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/")
    public List<Address> get(){
        return addressService.findAll();
    }
    @GetMapping("/{id}")
    public Address getById(@PathVariable int id){
        return addressService.find(id);
    }
    @PostMapping("/")
    public Address save(@RequestBody Address address){
        return addressService.save(address);
    }
    @PutMapping("/{id}")
    public Address save(@RequestBody Address address, @PathVariable int id){
        Address foundAddress = getById(id);
        if (foundAddress != null){
            address.setId(id);
            return addressService.save(address);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public Address save(@PathVariable int id){
        Address address = addressService.find(id);
        addressService.delete(address);
        return address;
    }
}
