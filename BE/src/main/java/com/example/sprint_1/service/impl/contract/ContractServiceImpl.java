package com.example.sprint_1.service.impl.contract;

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
    public Contract getContractByContractId(String contractId) {
        return contractRepository.findByContractId(contractId);
    }

    @Override
    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Contract updateContract(String id, Contract contractRequest) {
        Contract contract = contractRepository.findByContractId(id);
        contract.setContractDate(contractRequest.getContractDate());
        contract.setStartDate(contractRequest.getStartDate());
        contract.setEndDate(contractRequest.getEndDate());
        contract.setRentCost(contractRequest.getRentCost());
        contract.setTotalCost(contractRequest.getTotalCost());
        contract.setContractContent(contractRequest.getContractContent());
        contract.setDeleteFlag(contractRequest.getDeleteFlag());
        contract.setCustomer(contractRequest.getCustomer());
        contract.setEmployee(contractRequest.getEmployee());
        contract.setGround(contractRequest.getGround());
        return contractRepository.save(contract);
    }
}
