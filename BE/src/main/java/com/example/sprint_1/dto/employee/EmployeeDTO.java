package com.example.sprint_1.dto.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    String employeeName;
    String employeeBirthday;
    Boolean employeeGender;
    String employeeGmail;
    String employeeIdCard;
    String employeeAddress;
    String employeePhone;
    Double employeeSalary;
    PositionDTO position;
    AccountDTO account;
    String urlImage;
}