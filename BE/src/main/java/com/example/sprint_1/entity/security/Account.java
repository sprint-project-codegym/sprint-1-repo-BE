package com.example.sprint_1.entity.security;

import com.example.sprint_1.entity.employee.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "account")
public class Account {
    @Id
    @Column(name= "account_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    @Column(name = "user_name")
    private String userName;
    private String email;
    @Column(name = "encrypt_pw")
    private String encryptPw;
    private String token;
    @Column(name = "is_enable")
    private Boolean isEnable;
    @Column(name = "verification_code")
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

