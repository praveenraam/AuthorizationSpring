package com.packages.Authentication.Model.Users;

import com.packages.Authentication.Model.Abstract.User;
import com.packages.Authentication.Model.Enum.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin extends User {
    public Admin() {
    }

    public Admin(String email,String password, Role role) {
        super(email,    password, role);
    }
}
