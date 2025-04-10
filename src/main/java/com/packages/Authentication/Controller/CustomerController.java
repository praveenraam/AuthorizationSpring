package com.packages.Authentication.Controller;

import com.packages.Authentication.Model.Users.Customers;
import com.packages.Authentication.Service.UserService.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/getAll")
    public List<Customers> customersList(){
        return customerService.getAllCustomers();
    }

    @PostMapping("/customerRegister")
    public String register(@RequestBody Customers customer){
        return customerService.register(customer);
    };
}
