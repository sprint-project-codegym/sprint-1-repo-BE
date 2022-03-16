package com.example.sprint_1.service.impl.customer;

import com.example.sprint_1.entity.customer.Customer;
import com.example.sprint_1.repository.customer.CustomerRepository;
import com.example.sprint_1.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAllCustomer() {
        List<Customer> customers = customerRepository.findAllCustomer();
        return filterCustomer(customers);
    }


    @Override
    public  Customer findCustomerByCustomerId(String id) {
        return customerRepository.findCustomerByCustomerId(id);
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteCustomer(id);
    }

    @Override
    public List<Customer> filterCustomer(List<Customer> customers) {
        List<Customer> customerList = new ArrayList<>();
        for(Customer customer: customers){
            if(customer.getDeleteFlag()){
                customerList.add(customer);
            }
        }
        return customerList;
    }

    @Override
    public List<Customer> searchCustomerById(String id) {
        List<Customer> customers= customerRepository.searchCustomerById(id);
        return filterCustomer(customers);
    }

    @Override
    public List<Customer> searchCustomerByName(String name) {
        List<Customer> customers= customerRepository.searchCustomerByName(name);
        return filterCustomer(customers);
    }

    @Override
    public List<Customer> searchCustomerByIdAndName(String id, String name) {
        List<Customer> customers= customerRepository.searchCustomerByIdAndName(id,name);
        return filterCustomer(customers);
    }

}
