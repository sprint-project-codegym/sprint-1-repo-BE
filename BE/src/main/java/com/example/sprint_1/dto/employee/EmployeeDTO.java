package com.example.sprint_1.dto.employee;

import com.example.sprint_1.dto.security.AccountDTO;
import lombok.Data;

@Data
public class EmployeeDTO {
    private String employeeId;
    private String employeeName;
    private String employeeBirthday;
    private Boolean employeeGender;
    private String employeeIdCard;
    private String employeeGmail;
    private String employeeAddress;
    private String employeePhone;
    private Double employeeSalary;
    private Boolean deleteFlag;
    private AccountDTO account;
    private PositionDTO position;
    String urlImage;

}
