package com.packages.Authentication.Controller;

import com.packages.Authentication.Model.Users.Sellers;
import com.packages.Authentication.Service.UserService.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping("/seller/getAll")
    public List<Sellers> sellersList(){
        return sellerService.getAllSellers();
    }

    @PostMapping("/sellerRegister")
    public String register(@RequestBody Sellers seller){
        return sellerService.register(seller);
    }

}
