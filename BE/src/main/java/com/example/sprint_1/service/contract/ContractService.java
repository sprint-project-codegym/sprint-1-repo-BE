package com.example.sprint_1.service.contract;

import com.example.sprint_1.entity.contract.Contract;

import java.util.List;

public interface ContractService {
    public Contract getContractByContractId(String contractId);

    public Contract save(Contract contract);

    public List<Contract> findAll();

    public Contract updateContract(String id, Contract contract);
}
