package com.example.sprint_1.dto.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    String name;
    String dateOfBirth;
    Boolean gender;
    String email;
    String idCard;
    String address;
    String phone;
    Double salary;
    PositionDTO position;
    AccountDTO account;
}