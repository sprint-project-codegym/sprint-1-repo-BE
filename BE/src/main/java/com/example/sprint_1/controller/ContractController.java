package com.example.sprint_1.controller;

import com.example.sprint_1.dto.contract.ContractDTO;
import com.example.sprint_1.entity.contract.Contract;
import com.example.sprint_1.entity.customer.Customer;
import com.example.sprint_1.entity.ground.Ground;
import com.example.sprint_1.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/manager/contract")
public class ContractController {
    // Nguyen Dinh Hung Anh //
    @Autowired
    ContractService contractService;

    @GetMapping("/list") // Get list contract and search//
    public ResponseEntity<Page<Contract>> getListWithPagination(@RequestParam(defaultValue = "") String id,
                                                                @RequestParam(defaultValue = "") String customerName,
                                                                @RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "3") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Contract> contracts;
        contracts = contractService.findAllContractWithPagination(id, customerName, pageable);
        if (contracts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contracts, HttpStatus.OK);
    }

    @GetMapping("/list/delete/{id}") //delete contract//
    public ResponseEntity<String> deleteContractById(@PathVariable("id") String id, Model model) {
        Contract contract = contractService.findById(id);
        if (contract == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        contractService.deleteContractById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//    KienHQ create contract

    @GetMapping("/list-ground")
    public ResponseEntity<List<Ground>> getListGround() {
        return new ResponseEntity<>(contractService.findAllGround(), HttpStatus.OK);
    }

    @GetMapping("/list-customer")
    public ResponseEntity<List<Customer>> getListCustomer() {
        return new ResponseEntity<>(contractService.findAllCustomer(), HttpStatus.OK);
    }

    @PostMapping(value = "/create", produces = {"application/json"})
    public ResponseEntity<ContractDTO> createContract(@Validated @RequestBody ContractDTO dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        contractService.saveContract(dto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
