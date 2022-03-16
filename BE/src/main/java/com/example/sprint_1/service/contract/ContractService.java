package com.example.sprint_1.service.contract;

import com.example.sprint_1.entity.contract.Contract;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContractService {
    void saveContract(Contract contract);

}
