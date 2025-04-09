package com.packages.Authentication.Model.Users;


import com.packages.Authentication.Model.Abstract.User;
import com.packages.Authentication.Model.Enum.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "sellers")
public class Sellers extends User {

    public Sellers() {
    }

    public Sellers(String email,String password, Role role, String name, String productName) {
        super(email,password, role);
        this.name = name;
        this.productName = productName;
    }

    @Column(name = "user_name")
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "product_name")
    private String productName;
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

}
