package com.example.sprint_1.service.impl.contract;

import com.example.sprint_1.dto.contract.ContractDTO;
import com.example.sprint_1.entity.contract.Contract;
import com.example.sprint_1.entity.customer.Customer;
import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.entity.ground.Ground;
import com.example.sprint_1.repository.contract.ContractRepository;
import com.example.sprint_1.repository.customer.CustomerRepository;
import com.example.sprint_1.repository.ground.GroundRepository;
import com.example.sprint_1.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    GroundRepository groundRepository;

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public List<Ground> findAllGround() {
        return groundRepository.findAll();
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public void saveContract(ContractDTO dto) {
        Contract contract = new Contract();
        contract.setContractId(dto.getContractId());
        contract.setStartDate(dto.getStartDate());
        contract.setEndDate(dto.getEndDate());
        contract.setContractDate(dto.getContractDate());
        contract.setRentCost(dto.getRentCost());
        contract.setTotalCost(dto.getTotalCost());
        contract.setContractContent(dto.getContractContent());
        contract.setDeleteFlag(true);

        Customer cusEntity = new Customer();
        cusEntity.setCustomerId(dto.getCustomerId());
        contract.setCustomer(cusEntity);

        Employee empEntity = new Employee();
        empEntity.setEmployeeId(dto.getEmployeeId());
        contract.setEmployee(empEntity);

        Ground grEntity = new Ground();
        grEntity.setGroundId(dto.getGroundId());
        contract.setGround(grEntity);
        contractRepository.saveContract(contract);
    }

}
