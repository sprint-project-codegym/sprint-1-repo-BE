package com.example.sprint_1.dto.employee;

import lombok.Data;

import javax.persistence.Id;

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

    private PositionDTO position;


}
