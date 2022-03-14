package com.example.sprint_1.entity.employee;

import com.example.sprint_1.entity.contract.Contract;
import com.example.sprint_1.entity.security.Account;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "employee")
public class Employee {
    @Id
    private String employeeId;
    private String employeeName;
    @Column(columnDefinition = "Date")
    private String employeeBirthday;
    private Boolean employeeGender;
    private String employeeIdCard;
    private String employeeGmail;
    private String employeeAddress;
    private String employeePhone;
    private Double employeeSalary;
    private Boolean deleteFlag;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountId")
    @JsonBackReference
    private Account account;

    @ManyToOne(targetEntity = Position.class)
    @JoinColumn(name = "positionId")
    private Position position;

    @OneToMany(mappedBy = "employee")
    @JsonBackReference
    public List<Contract> contractList;
}
