package com.example.sprint_1.repository.security.customer;

import com.example.sprint_1.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}

