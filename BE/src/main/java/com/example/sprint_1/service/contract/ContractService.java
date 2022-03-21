package com.example.sprint_1.service.contract;

import com.example.sprint_1.dto.contract.ContractDTO;
import com.example.sprint_1.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ContractService {

    public void updateContractDTO(ContractDTO contractDTO);

    Page<Contract> findAllContractWithPagination(String id, String customerName, Pageable pageable);

    void deleteContractById(String id); //Delete contract by id

    Contract findById(String id); //Find contract by id

}




