package com.example.sprint_1.controller;

import com.example.sprint_1.entity.customer.Customer;
import com.example.sprint_1.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<Customer>> getList(@RequestParam("id") Optional<String> id, @RequestParam("name") Optional<String> name) {
        List<Customer> customers = customerService.findAllCustomer();
        if(id.isPresent() && !name.isPresent()) {
            customers = customerService.searchCustomerById(id.get());
        } else if(!id.isPresent() && name.isPresent()) {
            customers = customerService.searchCustomerByName(name.get());
        } else if(id.isPresent()) {
            customers = customerService.searchCustomerByIdAndName(id.get(),name.get());
        }
        if(customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    //NgaLT xoa khach hang
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteCustomerById (@PathVariable("id") String id){
        Customer customer = customerService.findCustomerByCustomerId(id);
           if(customer == null) {
               return new ResponseEntity<>("notOk",HttpStatus.NOT_FOUND);
           }else {
               customerService.deleteCustomer(id);
               return new ResponseEntity<>("OK", HttpStatus.OK);
           }

    }

}
