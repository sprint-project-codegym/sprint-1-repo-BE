package com.example.sprint_1.service.employee;

import com.example.sprint_1.dto.employee.EmployeeAcountDTO;
import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.entity.security.Account;

public interface PersonalInfoService {
    public Employee findEmployeeByEmployeeId(String id);

    public void updateInfoEmployeeDTO(EmployeeAcountDTO employeeAcountDTO);

    public void saveAccount(Integer id, String password);

    boolean checkPass(Integer id, String password);

    Account findById(Integer id);

    void updateAccountPassword(String encryptPw, Integer accountId);
}
