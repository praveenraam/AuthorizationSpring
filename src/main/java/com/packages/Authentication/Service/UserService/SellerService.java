package com.packages.Authentication.Service.UserService;

import com.packages.Authentication.Model.Users.Sellers;
import com.packages.Authentication.Repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

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

    public String verify(Sellers seller){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(seller.getEmail(),seller.getPassword()));
        if(authentication.isAuthenticated()) return jwtService.generateToken(seller.getEmail());
        return "";
    }

}
