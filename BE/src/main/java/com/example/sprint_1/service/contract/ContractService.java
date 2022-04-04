package com.example.sprint_1.service.contract;

import com.example.sprint_1.dto.contract.ContractDTO;
import com.example.sprint_1.dto.contract.ContractEditDto;
import com.example.sprint_1.entity.contract.Contract;
import com.example.sprint_1.entity.customer.Customer;
import com.example.sprint_1.entity.ground.Ground;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContractService {
    Page<Contract> findAllContractWithPagination(String id, String customerName, Pageable pageable);

    void deleteContractById(String id); //Delete contract by id

    Contract findById(String id); //Find contract by id

    void saveContract(ContractDTO dto); //KienHQ

    List<Ground> findAllGround(); //KienHQ

    List<Customer> findAllCustomer(); //KienHQ

    public List<Contract> findAll();

    //DongVTH
    Contract findContractById(String id);

    //DongVTH
    void updateContractDTO(String id, ContractEditDto contractEditDto);
}


