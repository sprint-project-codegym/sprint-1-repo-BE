package com.example.sprint_1.repository.contract;

import com.example.sprint_1.entity.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ContractRepository extends JpaRepository<Contract, String> {
    @Modifying
    @Query(value = "INSERT INTO Contract VALUES (:#{#contract.contractId}, :#{#contract.contractContent}, :#{#contract.contractDate}," +
            ":#{#contract.deleteFlag}, :#{#contract.endDate}, :#{#contract.rentCost}, :#{#contract.startDate}, :#{#contract.totalCost}, " +
            ":#{#contract.customer.customerId}, :#{#contract.employee.employeeId}, :#{#contract.ground.groundId})", nativeQuery = true)
    @Transactional
    void saveContract(Contract contract);
}
