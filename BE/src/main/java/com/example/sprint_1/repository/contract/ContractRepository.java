package com.example.sprint_1.repository.contract;

import com.example.sprint_1.entity.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, String> {
}
