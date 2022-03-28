package com.example.sprint_1.repository.employee;

import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.entity.security.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonalInfoRepository extends JpaRepository<Employee, String> {

    //Repo của Nhung

//    @Query(value = "SELECT employee.employee_name, employee.employee_address, employee.employee_birthday, " +
//            "employee.employee_gmail, employee.employee_phone, employee.employee_gender, account.user_name, " +
//            "account.encrypt_pw from employee \n" +
//            "join account on employee.account_id = account.account_id", nativeQuery = true)
//    *Hỏi tutor: Vì sao khi query từng trường thì gặp lỗi không tìm thấy trường employee_id

    @Query(value = "select * from employee where employee.employee_id = ?1", nativeQuery = true)
    Employee findEmployeeByEmployeeId(String id);


    @Query(value = "select account from account where account.account_id = ?1", nativeQuery = true)
    Employee findEmployeeByAccountId(String id);


    @Modifying
    @Query(value = "update employee e" +
            " set e.employee_name = ?2, e.employee_gender = ?3, e.employee_birthday = ?4, " +
            "e.employee_phone = ?5, e.employee_gmail = ?6, e.employee_address = ?7 " +
            "where e.employee_id = ?1", nativeQuery = true)
    void updateEmployee(String employee_id, String employee_name, String employee_gender, String employee_birthday, String employee_phone, String employee_gmail, String employee_address);

    @Modifying
    @Query(value = "update account a set a.account_encrypt_pw = ?2 where a.account_id = ?1", nativeQuery = true)
    void saveAccount(String id, String encrypt_pw);



}
