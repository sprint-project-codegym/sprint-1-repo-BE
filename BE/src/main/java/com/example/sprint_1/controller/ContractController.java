package com.example.sprint_1.controller;

import com.example.sprint_1.dto.contract.ContractDTO;
import com.example.sprint_1.entity.contract.Contract;
import com.example.sprint_1.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manager/contract")
public class ContractController {

    @Autowired
    ContractService contractService;

    @GetMapping("/list")
    public ResponseEntity<List<Contract>> getListContract() {
        return new ResponseEntity<>(contractService.findAll(), HttpStatus.OK);
    }

//    KienHQ create contract

    @PostMapping(value = "/create", produces = {"application/json"})
    public ResponseEntity<?> createContract(@Validated @RequestBody ContractDTO dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
         contractService.saveContract(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
