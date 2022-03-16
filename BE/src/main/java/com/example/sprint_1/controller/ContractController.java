package com.example.sprint_1.controller;

import com.example.sprint_1.dto.contract.ContractDTO;
import com.example.sprint_1.entity.contract.Contract;
import com.example.sprint_1.entity.customer.Customer;
import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.entity.ground.Ground;
import com.example.sprint_1.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/manager/contract")
public class ContractController {
    @Autowired
    ContractService contractService;

    @PostMapping(value = "/create", produces = {"application/json"})
    public ResponseEntity<Contract> createContract(@RequestBody ContractDTO dto) {

        Contract entity = new Contract();
        entity.setContractId(dto.getContractId());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setContractDate(dto.getContractDate());
        entity.setRentCost(dto.getRentCost());
        entity.setTotalCost(dto.getTotalCost());
        entity.setContractContent(dto.getContractContent());
        entity.setDeleteFlag(dto.getDeleteFlag());

        Customer cusEntity = new Customer();
        cusEntity.setCustomerId(dto.getCustomerId());
        entity.setCustomer(cusEntity);

        Employee empEntity = new Employee();
        empEntity.setEmployeeId(dto.getEmployeeId());
        entity.setEmployee(empEntity);

        Ground grEntity = new Ground();
        grEntity.setGroundId(dto.getGroundId());
        entity.setGround(grEntity);

        contractService.saveContract(entity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
