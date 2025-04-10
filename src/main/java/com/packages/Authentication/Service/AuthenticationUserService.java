package com.packages.Authentication.Service;

import com.packages.Authentication.Model.UserPrinciple.AdminPrinciple;
import com.packages.Authentication.Model.UserPrinciple.CustomerPrinciple;
import com.packages.Authentication.Model.UserPrinciple.SellerPrinciple;
import com.packages.Authentication.Model.Users.Admin;
import com.packages.Authentication.Model.Users.Customers;
import com.packages.Authentication.Model.Users.Sellers;
import com.packages.Authentication.Repository.AdminRepository;
import com.packages.Authentication.Repository.CustomerRepository;
import com.packages.Authentication.Repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationUserService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Admin admin = adminRepository.findByEmail(email);
        if(admin != null){
            return new AdminPrinciple(admin);
        }

        Sellers seller = sellerRepository.findByEmail(email);
        if(seller != null){
            return new SellerPrinciple(seller);
        }

        Customers customers = customerRepository.findByEmail(email);
        if(customers != null){
            return new CustomerPrinciple(customers);
        }

        throw new UsernameNotFoundException("User not found");
    }
}
