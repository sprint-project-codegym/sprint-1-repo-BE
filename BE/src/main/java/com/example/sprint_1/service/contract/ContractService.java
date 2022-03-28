package com.example.sprint_1.service.contract;

import com.example.sprint_1.dto.contract.ContractDTO;
import com.example.sprint_1.entity.customer.Customer;
import com.example.sprint_1.entity.ground.Ground;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContractService {
    void saveContract(ContractDTO dto);


    List<Ground> findAllGround();

    List<Customer> findAllCustomer();
}
