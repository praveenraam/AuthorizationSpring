package com.packages.Authentication.Controller;

import com.packages.Authentication.Model.Users.Admin;
import com.packages.Authentication.Service.UserService.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    private AdminService adminService;

    @GetMapping("/admin/getAll")
    public List<Admin> adminList(){
        return adminService.getAllAdmin();
    }

    @PostMapping("adminRegister")
    public String register(@RequestBody Admin admin){
        return adminService.register(admin);
    }

}
