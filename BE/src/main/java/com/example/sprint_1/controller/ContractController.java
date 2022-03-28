package com.example.sprint_1.controller;

import com.example.sprint_1.dto.contract.ContractDTO;
import com.example.sprint_1.entity.contract.Contract;
import com.example.sprint_1.entity.customer.Customer;
import com.example.sprint_1.entity.ground.Ground;
import com.example.sprint_1.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/manager/contract")
public class ContractController {

    @Autowired
    ContractService contractService;
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

    @GetMapping("/api/contract/list")
    public ResponseEntity<List<Contract>> getListContract() {
        List<Contract> contractList = contractService.findAll();
        return new ResponseEntity<>(contractList, HttpStatus.OK);
    }

    @PatchMapping(value = "/api/contract/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateContract(@Valid @RequestBody ContractDTO contractDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = "Lỗi định dạng";
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        contractService.updateContractDTO(contractDTO);
        return new ResponseEntity<>(contractDTO, HttpStatus.OK);
    }
}
