package com.example.sprint_1.entity.employee;

import com.example.sprint_1.entity.contract.Contract;
import com.example.sprint_1.entity.security.Account;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    private Account account;

    @ManyToOne(targetEntity = Position.class)
    @JoinColumn(name = "positionId")
    private Position position;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonBackReference
    public List<Contract> contractList;

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employeeBirthday='" + employeeBirthday + '\'' +
                ", employeeGender=" + employeeGender +
                ", employeeIdCard='" + employeeIdCard + '\'' +
                ", employeeGmail='" + employeeGmail + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", employeePhone='" + employeePhone + '\'' +
                ", employeeSalary=" + employeeSalary +
                ", deleteFlag=" + deleteFlag +
                ", account=" + account +
                ", position=" + position +
                ", contractList=" + contractList +
                '}';
    }
}
