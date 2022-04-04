package com.example.sprint_1.repository.contract;

import com.example.sprint_1.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ContractRepository extends JpaRepository<Contract, String> {

    @Query(value = "select contract.contract_id, contract.contract_content, contract.contract_date, contract.delete_flag, " +
            "contract.end_date, contract.rent_cost, contract.start_date, contract.total_cost,customer.customer_id, " +
            "customer.customer_name, ground.ground_id, employee.employee_id from contract " +
            "INNER JOIN customer on contract.customer_id = customer.customer_id " +
            "INNER JOIN ground on contract.ground_id = ground.ground_id " +
            "Inner JOIN employee on contract.employee_id = employee.employee_id " +
            "where contract.contract_id like %?1% and customer.customer_name like %?2% and contract.delete_flag = 1",
            countQuery= "select count(*) from contract INNER JOIN customer on contract.customer_id = customer.customer_id " +
                    "where contract.contract_id like %?1% and customer.customer_name like %?2% and contract.delete_flag = 1", nativeQuery = true)
    Page<Contract> findAllContractWithPagination(String id, String customerName, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "update contract set contract.delete_flag = 0 where contract.contract_id = :id ", nativeQuery = true)
    void deleteContract(@Param("id") String id);

    @Modifying
    @Query(value = "INSERT INTO Contract VALUES (:#{#contract.contractId}, :#{#contract.contractContent}, :#{#contract.contractDate}," +
            ":#{#contract.deleteFlag}, :#{#contract.endDate}, :#{#contract.rentCost}, :#{#contract.startDate}, :#{#contract.totalCost}, " +
            ":#{#contract.customer.customerId}, :#{#contract.employee.employeeId}, :#{#contract.ground.groundId})", nativeQuery = true)
    @Transactional
    void saveContract(Contract contract);

    //DongVTH
    @Transactional
    @Modifying
    @Query(value = "update `contract` as c set c.contract_content = :contract_content, c.contract_date = :contract_date," +
            "c.delete_flag = :delete_flag, c.end_date = :end_date, c.rent_cost =:rent_cost, c.start_date =:start_date, c.delete_flag =:delete_flag," +
            "c.total_cost = :total_cost, c.customer_id = :customer_id, c.employee_id = :employee_id, c.ground_id =:ground_id " +
            "where c.contract_id = :contract_id", nativeQuery = true)
    void updateContractDTO(@Param("contract_id") String contract_id, @Param("contract_content") String contract_content,
                           @Param("contract_date") String contract_date, @Param("end_date") String end_date, @Param("rent_cost") Double rent_cost,
                           @Param("start_date") String start_date, @Param("delete_flag") Boolean delete_flag, @Param("total_cost") Double total_cost,
                           @Param("customer_id") String customer_id, @Param("employee_id") String employee_id,
                           @Param("ground_id") String ground_id);
    //DongVTH
    @Query(value = "SELECT * FROM sprint_1.contract where contract_id = :contractId", nativeQuery = true)
    Contract getContractByContractId(@Param("contractId") String contractId);
}



