package com.example.sprint_1.service.customer;

import com.example.sprint_1.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerService {
    Page<Customer> findAllCustomerWithPagination(String id, String name,Pageable pageable );

    Customer findCustomerByCustomerId( String id);

    void deleteCustomer (@Param("id") String id);

    //ĐôngVTH ké 1 method
    List<Customer> getAllCustomer();
}
