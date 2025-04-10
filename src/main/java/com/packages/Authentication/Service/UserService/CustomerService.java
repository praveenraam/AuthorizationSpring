package com.packages.Authentication.Service.UserService;

import com.packages.Authentication.Model.Users.Customers;
import com.packages.Authentication.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public String register(Customers customer){
        // Password Encryption
        customer.setPassword(encoder.encode(customer.getPassword()));
        customerRepository.save(customer);

        if(customerRepository.existsById(customer.getId())){
            return "Success";
        }
        return "Failed";
    }


    public List<Customers> getAllCustomers() {
        return customerRepository.findAll();
    }
}
