package com.easy.car.service;

import com.easy.car.dto.CustomerDTO;
import com.easy.car.entity.Customer;
import com.easy.car.repo.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper modelMapper;


    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        customerRepo.save(modelMapper.map(customerDTO, Customer.class));
        return customerDTO;
    }

    public List<CustomerDTO> getAllCustomers() {
        Iterable<Customer> customers = customerRepo.findAll();
        return modelMapper.map(customers, new TypeToken<List<CustomerDTO>>() {}.getType());

    }

    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        customerRepo.save(modelMapper.map(customerDTO, Customer.class));
        return customerDTO;
    }

    public boolean deleteCustomer(CustomerDTO customerDTO) {
        customerRepo.delete(modelMapper.map(customerDTO, Customer.class));
        return true;
    }

    public void registerUser(CustomerDTO customerDTO) throws IOException {
        Customer existingUser = customerRepo.findByUsername(customerDTO.getUsername());
        if (existingUser != null) {
            throw new IllegalArgumentException("Username already exists");
        }

        Customer customer = new Customer();
        customer.setUsername(customerDTO.getUsername());
        customer.setPassword(customerDTO.getPassword());
        // Set other user properties

        // Save user to database
        customerRepo.save(customer);

        // Save file to server or database
        // saveFile(userDTO.getFile());
    }
}
