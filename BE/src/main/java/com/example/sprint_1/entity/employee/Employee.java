package com.example.sprint_1.entity.employee;

import com.example.sprint_1.entity.contract.Contract;
import com.example.sprint_1.entity.security.Account;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "employee")
public class Employee {
    @Id
    private String employeeId;
    private String employeeName;
    private String employeeBirthday;
    private Boolean employeeGender;
    @Column(unique = true)
    private String employeeIdCard;
    @Column(unique = true)
    private String employeeGmail;
    private String employeeAddress;
    @Column(unique = true)
    private String employeePhone;
    private Double employeeSalary;
    private String urlImage;
    private Boolean deleteFlag;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountId")

    @JsonBackReference(value = "account_employee")
    private Account account;

    @ManyToOne(targetEntity = Position.class)
    @JoinColumn(name = "positionId")
    private Position position;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonBackReference(value = "employee_contract")
    public List<Contract> contractList;

}
