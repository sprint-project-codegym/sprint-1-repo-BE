package com.example.sprint_1.dto.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AccountDTO {
    private Integer accountId;
    private String username;
    private String email;
    private String password;
    private String token;
    private Boolean isEnable;
    private String verificationCode;
}
