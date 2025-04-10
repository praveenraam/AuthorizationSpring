package com.packages.Authentication.Service.UserService;

import com.packages.Authentication.Model.Users.Admin;
import com.packages.Authentication.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    public String register(Admin admin) {
        admin.setPassword(encoder.encode(admin.getPassword()));

        if(adminRepository.existsById(admin.getId())){
            return "Successful";
        }
        return "Failed";
    }
}
