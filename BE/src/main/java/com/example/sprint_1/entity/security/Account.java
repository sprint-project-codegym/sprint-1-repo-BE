package com.example.sprint_1.entity.security;

import com.example.sprint_1.entity.employee.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
//    @NotBlank(message = "Tên tài khoản không được để trống")
//    @Pattern(regexp = "^\\S[a-zA-Z0-9@.]{3,29}$", message = "Tên tài khoản không đúng định dạng!")
    private String userName;
    private String email;
//    @NotBlank(message = "Mật khẩu không được để trống")
//    @Pattern(regexp = "^[-@.\\/#&+\\w\\s]{3,15}$", message = "Mật khẩu không đúng định dạng!")
    private String encryptPw;
    private String token;
    private Boolean isEnable;
    private String verificationCode;

    @OneToOne(mappedBy = "account")
    @JsonBackReference
    private Employee employee;

    @OneToMany(mappedBy = "account")
    @JsonBackReference
    private Set<AccountRole> accountRoleList;

    public Account(String userName, String encryptPw) {
        this.userName = userName;
        this.encryptPw = encryptPw;
    }
}

