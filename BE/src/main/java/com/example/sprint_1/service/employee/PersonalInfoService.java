package com.example.sprint_1.service.employee;

import com.example.sprint_1.dto.employee.EmployeeAcountDTO;
import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.entity.security.Account;
<<<<<<< HEAD
import org.springframework.stereotype.Service;


@Service
public interface PersonalInfoService {
//Service của Nhung

    Employee findEmployeeById(String id);

    Account findAccountById(String id);

    void saveEmployee(String id,EmployeeAcountDTO employeeAcountDTO);

//    boolean checkPass(String id, String encrypt_pw);

    void saveAccount(String id, String encrypt_pw);
=======

public interface PersonalInfoService {
    public Employee findEmployeeByEmployeeId(String id);

    public void updateInfoEmployeeDTO(EmployeeAcountDTO employeeAcountDTO);

    public void saveAccount(Integer id, String password);

    boolean checkPass(Integer id, String password);

    Account findById(Integer id);

    void updateAccountPassword(String encryptPw, Integer accountId);
>>>>>>> 3d2b27c42e637c107910d85f75dd36f344f0ee13
}
