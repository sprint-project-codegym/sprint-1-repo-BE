package com.example.sprint_1.repository.employee;

import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.entity.security.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface PersonalInfoRepository extends JpaRepository<Employee, String> {

    //Repo của Nhung
        @Query(value = "select e.employee_id, e.delete_flag, e.employee_address, e.employee_birthday " +
            ", e.employee_gender, e.employee_gmail, e.employee_id_card, e.employee_name, e.employee_phone, " +
                "e.employee_salary, e.account_id, e.position_id, e.url_image from employee as e " +
            "where account_id = :accountId", nativeQuery = true)
//    @Query(value = "select * from sprint_1.`employee` e where e.`employee_id` = :employeeId", nativeQuery = true)
    Employee getEmployeeByAccountId(@Param("accountId") Integer accountId);


    @Modifying
    @Transactional
    @Query(value = "update sprint_1.employee as e set e.employee_name = :employee_name, e.employee_gender = :employee_gender," +
            "e.employee_birthday = :employee_birthday, e.employee_phone = :employee_phone, e.employee_gmail = :employee_gmail," +
            " e.employee_address = :employee_address where e.employee_id = :employee_id", nativeQuery = true)
    void updateEmployeeDTO(@Param("employee_id") String employee_id,
                           @Param("employee_name") String employee_name,
                           @Param("employee_gender") Boolean employee_gender,
                           @Param("employee_birthday") String employee_birthday,
                           @Param("employee_phone") String employee_phone,
                           @Param("employee_gmail") String employee_gmail,
                           @Param("employee_address") String employee_address);

    @Modifying
    @Transactional
    @Query(value = "update account as a set e.employee_name = :employee_name, e.employee_gender = :employee_gender," +
            "e.employee_birthday = :employee_birthday, e.employee_phone = :employee_phone, e.employee_gmail = :employee_gmail, " +
            "e.employee_address = :employee_address, e.account_id = :account_id where e.employee_id = :employee_id", nativeQuery = true)
    void updateAccount(@Param("employee_id") String employee_id,
                       @Param("employee_name") String employee_name,
                       @Param("employee_gender") Boolean employee_gender,
                       @Param("employee_birthday") String employee_birthday,
                       @Param("employee_phone") String employee_phone,
                       @Param("employee_gmail") String employee_gmail,
                       @Param("employee_address") String employee_address,
                       @Param("account_id") Integer account_id);

//    @Query(value = "select account.user_name, account.encrypt_pw from account as a where a.account_id= ?1", nativeQuery = "true")
//    Account findAccountById(Integer id);


    @Modifying
    @Transactional
    @Query(value = "update sprint_1.account as a set a.encrypt_pw =?2 " +
            "where a.account_id = ?1", nativeQuery = true)
    void saveAccount(Integer id, String password);

    @Query(value = "SELECT a.* " +
            "FROM account as a WHERE a.account_id = ?1", nativeQuery = true)
    Optional<Account> findById(Integer id);

    @Modifying
    @Transactional
    @Query(value = " UPDATE account " +
            "SET account.encrypt_pw = ?1 " +
            "WHERE account.account_id = ?2 ", nativeQuery = true)
    void updateAccountPassword(String encryptPw, Integer accountId);
}
