package com.example.sprint_1.service.impl.contract;


import com.example.sprint_1.dto.contract.ContractDTO;


import com.example.sprint_1.entity.contract.Contract;
import com.example.sprint_1.repository.contract.ContractRepository;
import com.example.sprint_1.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;

    @Override
    public void updateContractDTO(ContractDTO contractDTO) {
        contractRepository.updateContractDTO(contractDTO.getContractId(), contractDTO.getContractContent(),
                contractDTO.getContractDate(), contractDTO.getDeleteFlag(),
                contractDTO.getEndDate(), contractDTO.getRentCost(),
                contractDTO.getStartDate(), contractDTO.getTotalCost(),
                contractDTO.getCustomer().getCustomerId(), contractDTO.getEmployee().getEmployeeId(),
                contractDTO.getGround().getGroundId());
    }

    @Override
    public void deleteContractById(String id) {
        contractRepository.deleteContract(id);
    }

    @Override
    public Contract findById(String id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Contract> findAllContractWithPagination(String id, String customerName, Pageable pageable) {
        return contractRepository.findAllContractWithPagination(id, customerName, pageable);
    }

}
