package com.example.sprint_1.service.impl.customer;

import com.example.sprint_1.entity.customer.Customer;
import com.example.sprint_1.repository.customer.CustomerRepository;
import com.example.sprint_1.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAllCustomerWithPagination(String id, String name, Pageable pageable) {
        return customerRepository.findAllCustomerWithPagination(id, name, pageable);
    }

    @Override
    public Customer findCustomerByCustomerId(String id) {
        return customerRepository.findCustomerByCustomerId(id);
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteCustomer(id);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();
    }
}
