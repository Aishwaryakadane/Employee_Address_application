package com.project.EA.Service;

import com.project.EA.Model.Address;
import com.project.EA.Model.Employee;
import com.project.EA.Repo.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    IAddressRepo addressRepo;

    public List<Address> getallemployees() {
        return addressRepo.findAll();
    }

    public Address getById(Long id) {
        return addressRepo.findById(id).orElseThrow();
    }

    public String addAddresses(Address address) {
        addressRepo.save(address);
        return "Address added.........";
    }

    public String updateAddressById(Long id, Address address) {
        Optional<Address> oldAddress = addressRepo.findById(id);
        if (oldAddress.isPresent()) {
            Address currentAddress = oldAddress.get();
            currentAddress.setStreet(address.getStreet());
            currentAddress.setState(address.getState());
            currentAddress.setCity(address.getCity());
            currentAddress.setZipcode(address.getZipcode());
            addressRepo.save(currentAddress);
            return "address updated successfully.........";
        } else {
            return "not found";
        }
    }

    public String deleteAddress(Long id) {

            addressRepo.deleteById(id);
            return "deleted successfully..........";
        }

}


