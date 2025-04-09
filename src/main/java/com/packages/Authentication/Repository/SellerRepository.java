package com.packages.Authentication.Repository;

import com.packages.Authentication.Model.Users.Sellers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Sellers,Long> {
}
