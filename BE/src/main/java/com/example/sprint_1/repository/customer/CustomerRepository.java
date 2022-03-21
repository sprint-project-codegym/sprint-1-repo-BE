package com.example.sprint_1.repository.customer;

import com.example.sprint_1.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}

