package com.example.sprint_1.repository.contract;

import com.example.sprint_1.entity.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ContractRepository extends JpaRepository<Contract, String> {
    @Query(value = "SELECT contract_id, contract_content, contract_date, delete_flag, end_date, rent_cost, " +
            "start_date, total_cost, customer_id, employee_id, ground_id FROM `sprint-1`.contract " +
            "where `contract`.`contract_id` = :contractId", nativeQuery = true)
    Contract findByContractId(@Param("contractId") String contractId);

    @Transactional
    @Modifying
    @Query(value = "update `contract` as c set c.contract_content = :contract_content, c.contract_date = :contract_date," +
            "c.delete_flag = :delete_flag, c.end_date = :end_date, c.rent_cost =:rent_cost, c.start_date =:start_date, " +
            "c.total_cost = :total_cost, c.customer_id = :customer_id, c.employee_id = :employee_id, c.ground_id =:ground_id " +
            "where c.contract_id = :contract_id", nativeQuery = true)
    void updateContractDTO(@Param("contract_id") String contract_id, @Param("contract_content") String contract_content,
                           @Param("contract_date") String contract_date, @Param("delete_flag") Boolean delete_flag,
                           @Param("end_date") String end_date, @Param("rent_cost") Double rent_cost,
                           @Param("start_date") String start_date, @Param("total_cost") Double total_cost,
                           @Param("customer_id") String customer_id, @Param("employee_id") String employee_id,
                           @Param("ground_id") String ground_id);
}
