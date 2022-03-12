package com.example.sprint_1.entity.security;

import com.example.sprint_1.entity.employee.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    private String userName;
    private String email;
    private String encriptPw;
    private String token;
    private Boolean isEnable;
    private String verificationCode;

    @OneToOne(mappedBy = "accounts")
    @JsonBackReference
    private AccountRole accountRole;

    @OneToOne(mappedBy = "accountOfEmployee")
    @JsonBackReference
    private Employee employee;
}
