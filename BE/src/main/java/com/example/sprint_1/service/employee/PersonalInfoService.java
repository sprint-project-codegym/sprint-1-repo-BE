package com.example.sprint_1.service.employee;

import com.example.sprint_1.dto.employee.EmployeeAcountDTO;
import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.entity.security.Account;
import org.springframework.stereotype.Service;


@Service
public interface PersonalInfoService {
//Service của Nhung

    Employee findEmployeeById(String id);

    Account findAccountById(String id);

    void saveEmployee(String id,EmployeeAcountDTO employeeAcountDTO);

//    boolean checkPass(String id, String encrypt_pw);

    void saveAccount(String id, String encrypt_pw);
}
