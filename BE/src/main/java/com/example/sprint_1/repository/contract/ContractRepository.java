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
}



