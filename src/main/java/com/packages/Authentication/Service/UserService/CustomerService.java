package com.packages.Authentication.Service.UserService;

import com.packages.Authentication.Model.Users.Customers;
import com.packages.Authentication.Model.Users.Sellers;
import com.packages.Authentication.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

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

    public String verify(Customers customer){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(customer.getEmail(),customer.getPassword()));
        if(authentication.isAuthenticated()) return jwtService.generateToken(customer.getEmail());
        return "";
    }

    public List<Customers> getAllCustomers() {
        return customerRepository.findAll();
    }
}
