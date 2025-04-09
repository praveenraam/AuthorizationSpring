package com.packages.Authentication.Model.Users;

import com.packages.Authentication.Model.Abstract.User;
import com.packages.Authentication.Model.Enum.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customers extends User {

    public Customers(){}

    public Customers(String email,String password, Role role, String name, String address) {
        super(email,password, role);
        this.name = name;
        this.address = address;
    }


    @Column(name = "user_name",unique = true)
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "address")
    private String address;
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
