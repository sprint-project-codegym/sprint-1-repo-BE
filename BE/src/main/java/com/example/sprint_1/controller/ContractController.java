package com.example.sprint_1.controller;

import com.example.sprint_1.entity.contract.Contract;
import com.example.sprint_1.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContractController {
    // Nguyen Dinh Hung Anh //
    @Autowired
    ContractService contractService;

    @GetMapping("/list") // Get list contract and search//
    public ResponseEntity<Page<Contract>> GetListWithPagination(@RequestParam(defaultValue = "") String id,
                                                                @RequestParam(defaultValue = "") String customerName,
                                                                @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Contract> contracts;
        contracts = contractService.findAllContractWithPagination(id, customerName,pageable);
        if(contracts.isEmpty()){
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contracts,HttpStatus.OK);
    }
    @DeleteMapping("/list/delete/{id}") //delete contract//
    public ResponseEntity<String> deleteContractById(@PathVariable("id") String id, Model model) {
        Contract contract = contractService.findById(id);
        if(contract == null) {
            return new ResponseEntity<>("Không tìm thấy hợp đồng" ,HttpStatus.NOT_FOUND);
        }
        contractService.deleteContractById(id);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
//    @GetMapping("/list")
//    public ResponseEntity<List<Contract>> listAllContract(@RequestParam("id") Optional<String> id, @RequestParam("customerName") Optional<String> customerName) {
//        List<Contract> contracts = contractService.findAll();
//        if(id.isPresent() && !customerName.isPresent()) {
//            contracts = contractService.findByIdContaining(id.get());
//        } else if(!id.isPresent() && customerName.isPresent()) {
//            contracts = contractService.findByCustomerName(customerName.get());
//        } else if(id.isPresent()) {
//            contracts = contractService.findByIdAndCustomerName(id.get(),customerName.get());
//        }
//        if (contracts.isEmpty()) {
//            return new ResponseEntity<List<Contract>>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(contracts, HttpStatus.OK);
//    }
//    @GetMapping("/list")
//    public ResponseEntity<List<Contract>> listAllContract() {
//        List<Contract> contracts = contractService.findAll();
//        if (contracts.isEmpty()) {
//            return new ResponseEntity<List<Contract>>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(contracts, HttpStatus.OK);
//    }


//    @GetMapping("/list/search/{id}/{tenKhachHang}")
//    public ResponseEntity<List<Contract>> findContract(@PathVariable("id","customerName") String id, String customerName, Model model) {
//        List<Contract> contracts = contractService.searchContract(id, customerName);
//        if (contracts.isEmpty()) {
//            return new ResponseEntity<List<Contract>>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(contracts, HttpStatus.OK);
//    }
}
