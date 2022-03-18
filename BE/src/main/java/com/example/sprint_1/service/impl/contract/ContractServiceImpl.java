package com.example.sprint_1.service.impl.contract;

import com.example.sprint_1.dto.contract.ContractDTO;
import com.example.sprint_1.entity.contract.Contract;
import com.example.sprint_1.repository.contract.ContractRepository;
import com.example.sprint_1.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public void updateContractDTO(String id, ContractDTO contractDTO) {
        contractRepository.updateContractDTO(id, contractDTO.getContractContent(),
                contractDTO.getContractDate(), contractDTO.getDeleteFlag(),
                contractDTO.getEndDate(), contractDTO.getRentCost(),
                contractDTO.getStartDate(), contractDTO.getTotalCost(),
                contractDTO.getCustomer().getCustomerId(), contractDTO.getEmployee().getEmployeeId(),
                contractDTO.getGround().getGroundId());
    }

}
