package com.example.sprint_1.service.contract;

import com.example.sprint_1.dto.contract.ContractDTO;
import com.example.sprint_1.entity.contract.Contract;

import java.util.List;

public interface ContractService {
    public List<Contract> findAll();

    public void updateContractDTO(ContractDTO contractDTO);
}
