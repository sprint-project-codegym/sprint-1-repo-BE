package com.example.sprint_1.controller;

import com.example.sprint_1.entity.customer.Customer;
import com.example.sprint_1.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
//@RequestMapping("api/home")
@CrossOrigin(origins = "*")
//@CrossOrigin("http://localhost:4200")
public class CustomerController {
    /**
     * Le Thi Nga
     */

    @Autowired
    private CustomerService customerService;

    //NgaLT hien thi list khach hang, tim kiem khach hang
    @GetMapping("/customer/list")
    public ResponseEntity<Page<Customer>> getListCustomerWithPagination(@RequestParam(defaultValue = "0") int page,
                                                                        @RequestParam(defaultValue = "5") int size,
                                                                        @RequestParam(defaultValue = "") String id,
                                                                        @RequestParam(defaultValue = "") String name) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Customer> customers;
        customers = customerService.findAllCustomerWithPagination(id, name, pageable);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    //NgaLT delete customer
    @GetMapping(value = "/customer/list/delete/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable("id") String id) {
        Customer customer = customerService.findCustomerByCustomerId(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            customerService.deleteCustomer(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
