package com.project.EA.Controller;

import com.project.EA.Model.Address;
import com.project.EA.Model.Employee;
import com.project.EA.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;


    @GetMapping("addresses")
    public List<Address> getAllAddresses(){
        return addressService.getallemployees();
    }

    @GetMapping("address/{id}")
    public Address getById(@PathVariable Long id){
        return addressService.getById(id);
    }

    @PostMapping("addresses")
    public String addAddresses(@RequestBody Address address){
        return addressService.addAddresses(address);
    }

    @PutMapping("updating/address/{id}")
    public String updateAddressById(@PathVariable Long id, @RequestBody Address address){
        return addressService.updateAddressById(id,address);
    }

    @DeleteMapping("address/{id}")
    public String deleteAddress(@PathVariable Long id){
        return addressService.deleteAddress(id);
    }
}
