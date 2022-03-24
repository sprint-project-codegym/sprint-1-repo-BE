package com.example.sprint_1.controller;


import com.example.sprint_1.dto.contract.ContractDTO;
import com.example.sprint_1.entity.contract.Contract;
import com.example.sprint_1.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContractController {
    // Nguyen Dinh Hung Anh //
    @Autowired
    ContractService contractService;


    // DongVTH edit
    @PatchMapping(value = "/contract/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateContract(@Valid @RequestBody ContractDTO contractDTO, BindingResult bindingResult, @PathVariable("id") String id) {
        if (bindingResult.hasErrors()) {
            String message = "Lỗi định dạng";
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        contractService.updateContractDTO(id, contractDTO);
        return new ResponseEntity<>(contractDTO, HttpStatus.OK);
    }

    @GetMapping("/contract/list") // Get list contract and search//
    public ResponseEntity<Page<Contract>> getListWithPagination(@RequestParam(defaultValue = "") String id,
                                                                @RequestParam(defaultValue = "") String customerName,
                                                                @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Contract> contracts;
        contracts = contractService.findAllContractWithPagination(id, customerName, pageable);
        if (contracts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contracts, HttpStatus.OK);
    }

    @DeleteMapping("/list/delete/{id}") //delete contract//
    public ResponseEntity<String> deleteContractById(@PathVariable("id") String id, Model model) {
        Contract contract = contractService.findById(id);
        if (contract == null) {
            return new ResponseEntity<>("Không tìm thấy hợp đồng", HttpStatus.NOT_FOUND);
        }
        contractService.deleteContractById(id);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("/contract/{id}")
    public ResponseEntity<Contract> getContractByContractId(@PathVariable("id") String id) {
        Contract contract = contractService.findContractById(id);
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }


}
