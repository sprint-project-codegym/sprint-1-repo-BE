package com.example.sprint_1.controller;

import com.example.sprint_1.dto.contract.ContractDTO;
import com.example.sprint_1.entity.contract.Contract;
import com.example.sprint_1.service.impl.contract.ContractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ContractController {
    @Autowired
    ContractServiceImpl contractService;

    @GetMapping("/api/contract/list")
    public ResponseEntity<List<Contract>> getListContract() {
        List<Contract> contractList = contractService.findAll();
        return new ResponseEntity<>(contractList, HttpStatus.OK);
    }

    @PutMapping(value = "/api/contract/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateContract(@Valid @RequestBody ContractDTO contractDTO, BindingResult bindingResult, @PathVariable("id") String id) {
        if (bindingResult.hasErrors()) {
            String message = "Lỗi định dạng";
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        contractService.updateContractDTO(id, contractDTO);
        return new ResponseEntity<>(contractDTO, HttpStatus.OK);
    }
}
