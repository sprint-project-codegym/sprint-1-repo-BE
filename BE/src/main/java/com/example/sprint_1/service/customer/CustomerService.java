package com.example.sprint_1.service.customer;

import com.example.sprint_1.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomer();

    Customer findCustomerByCustomerId( String id);

    void deleteCustomer (@Param("id") String id);

    List<Customer> filterCustomer(List<Customer> customers);

    List<Customer> searchCustomerById(String id);

    List<Customer> searchCustomerByName(String name );

    List<Customer> searchCustomerByIdAndName(String id, String name );

}
