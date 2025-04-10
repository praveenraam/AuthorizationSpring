package com.packages.Authentication.Repository;

import com.packages.Authentication.Model.Users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findByEmail(String email);
}
