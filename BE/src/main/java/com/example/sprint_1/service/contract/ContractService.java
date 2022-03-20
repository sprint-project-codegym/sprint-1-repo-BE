package com.example.sprint_1.service.contract;

import com.example.sprint_1.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContractService {

    Page<Contract> findAllContractWithPagination(String id, String customerName, Pageable pageable);

    void deleteContractById(String id); //Delete contract by id

    Contract findById(String id); //Find contract by id
}

//    List<Contract> findAll(); //Get all contract

//    List<Contract> filterContract(List<Contract> contracts); // filter contract have delete_flag = 1
//
//    List<Contract> findByIdAndCustomerName(String id, String customerName); //search contract by id and customername
//
//    List<Contract> findByIdContaining(String id); //search contract by id
//
//    List<Contract> findByCustomerName(String customerName); //seach contract by customer name


