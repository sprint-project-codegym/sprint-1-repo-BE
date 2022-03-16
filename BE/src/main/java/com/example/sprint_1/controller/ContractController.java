package com.example.sprint_1.controller;

import com.example.sprint_1.dto.contract.ContractDTO;
import com.example.sprint_1.entity.contract.Contract;
import com.example.sprint_1.service.contract.ContractService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContractController {
    @Autowired
    ContractService contractService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/api/contract/list")
    public ResponseEntity<List<Contract>> getListContract() {
        List<Contract> contractList = contractService.findAll();
        return new ResponseEntity<>(contractList, HttpStatus.OK);
    }

    @PatchMapping(value = "/api/contract/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContractDTO> editContract(@PathVariable("id") String id, @RequestBody ContractDTO contractDTO) {
        Contract contractRequest = modelMapper.map(contractDTO, Contract.class);
        Contract contract1 = contractService.updateContract(contractDTO.getContractId(), contractRequest);
        ContractDTO contractResponse = modelMapper.map(contract1, ContractDTO.class);
        return ResponseEntity.ok().body(contractResponse);
    }
}
