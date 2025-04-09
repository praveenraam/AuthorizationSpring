package com.packages.Authentication.Repository;

import com.packages.Authentication.Model.Users.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customers,Long> {
}
