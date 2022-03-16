package com.example.sprint_1.repository.contract;

import com.example.sprint_1.entity.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, String> {
    @Query(value = "SELECT * FROM `sprint-1`.contract where `contract`.`contract_id` = :contractId",nativeQuery = true)
    Contract findByContractId(@Param("contractId") String contractId);


}
