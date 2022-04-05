package com.example.sprint_1.dto.employee;

import com.example.sprint_1.dto.security.AccountDTO;
import com.sun.org.apache.xpath.internal.objects.XString;
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
    private String urlImage;

    private AccountDTO account;
}
