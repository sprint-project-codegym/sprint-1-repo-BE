package com.example.sprint_1.service.impl.contract;

import com.example.sprint_1.entity.contract.Contract;
import com.example.sprint_1.repository.contract.ContractRepository;
import com.example.sprint_1.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;
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
//    @Override
//    public List<Contract> findAll() {
//
//        List<Contract> contracts = contractRepository.findAllContract();
//        return filterContract(contracts);
//    }

//    @Override
//    public List<Contract> filterContract(List<Contract> contracts) {
//        List<Contract> contractList = new ArrayList<>();
//        for (Contract contract : contracts) {
//            if (contract.getDeleteFlag()) {
//                contractList.add(contract);
//            }
//        }
//        return contractList;
//    }

    //
//    @Override
//    public List<Contract> findByIdAndCustomerName(String id, String customerName) {
//        List<Contract> contracts = contractRepository.findByContractIdContainingAndCustomerNameContaining(id, customerName);
//        return filterContract(contracts);
//    }
//
//    @Override
//    public List<Contract> findByIdContaining(String id) {
//        List<Contract> contracts = contractRepository.findByContractIdContaining(id);
//        return filterContract(contracts);
//    }
//
//    @Override
//    public List<Contract> findByCustomerName(String customerName) {
//        List<Contract> contracts = contractRepository.findByCustomerNameContaining(customerName);
//        return filterContract(contracts);
//    }

//    @Override
//    public List<Contract> searchContract() {
//        List<Contract> contracts = contractRepository.searchContract();
//        return contracts;
//    }
}
