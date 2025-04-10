package com.packages.Authentication.Service.UserService;

import com.packages.Authentication.Model.Users.Sellers;
import com.packages.Authentication.Repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public List<Sellers> getAllSellers() {
        return sellerRepository.findAll();
    }

    public String register(Sellers seller) {
        seller.setPassword(encoder.encode(seller.getPassword()));
        sellerRepository.save(seller);

        if(sellerRepository.existsById(seller.getId())){
            return "Successful";
        }
        return "Failed";
    }
}
