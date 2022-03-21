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
    String name;
    String dateOfBirth;
    String gender;
    String email;
    String idCard;
    String address;
    String phone;
    String salary;
    PositionDTO position;
    AccountDTO account;
}