package com.example.sprint_1.dto.employee;

<<<<<<< HEAD
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




=======
import com.example.sprint_1.dto.security.AccountDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

//Của Nhung
@Setter
@Getter
@NoArgsConstructor
public class EmployeeAcountDTO {
    @NotEmpty
    private String employeeId;
    @NotEmpty
    private String employeeName;
    @NotEmpty
    private String employeeBirthday;
    @NotNull
    private Boolean employeeGender;
    @NotEmpty
    @Email
    private String employeeGmail;
    @NotEmpty
    @Length(min = 1, max = 50)
    private String employeeAddress;
    @NotEmpty
    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$")
    private String employeePhone;

    private AccountDTO account;
>>>>>>> 3d2b27c42e637c107910d85f75dd36f344f0ee13
}
