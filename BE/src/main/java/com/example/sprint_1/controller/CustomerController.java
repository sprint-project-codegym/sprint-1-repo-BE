package com.example.sprint_1.controller;

import com.example.sprint_1.entity.customer.Customer;
import com.example.sprint_1.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/public/customer")
@CrossOrigin(origins = "*")
public class CustomerController {
    /**
     * Le Thi Nga
     */

    @Autowired
    private CustomerService customerService;

    //NgaLT hien thi list khach hang, tim kiem khach hang
    @GetMapping("/list")
    public ResponseEntity<Page<Customer>> GetListWithPagination(@RequestParam(defaultValue = "") String id,
                                                                @RequestParam(defaultValue = "") String name,
                                                                @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Customer> customers;
        customers = customerService.findAllCustomerWithPagination(id, name,pageable);
        if(customers.isEmpty()){
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers,HttpStatus.OK);
    }

    //NgaLT xoa khach hang
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable("id") String id) {
        Customer customer = customerService.findCustomerByCustomerId(id);
        if (customer == null) {
            return new ResponseEntity<>("notOk", HttpStatus.NOT_FOUND);
        } else {
            customerService.deleteCustomer(id);
            return new ResponseEntity<>("OK", HttpStatus.OK);
        }
    }
}
