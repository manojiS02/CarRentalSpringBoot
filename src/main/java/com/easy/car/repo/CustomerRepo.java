package com.easy.car.repo;

import com.easy.car.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    Customer findByUsername(String username);
}
