package com.example.sprint_1.dto.employee;

import com.example.sprint_1.entity.security.Account;
import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeAcountDTO {
    private String employeeId;
    private String employeeName;
    private String employeeBirthday;
    private Boolean employeeGender;
    private String employeeGmail;
    private String employeeAddress;
    private String employeePhone;
    private String employeeAccountUserName;
    private String employeeAccountPw;




}
