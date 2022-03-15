package com.example.sprint_1.entity.employee;

import com.example.sprint_1.entity.contract.Contract;
import com.example.sprint_1.entity.security.Account;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;


@Entity(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String employeeCode;
    private String employeeName;
    private String employeeBirthday;
    private Boolean employeeGender;
    private String employeeIdCard;
    private String employeeGmail;
    private String employeeAddress;
    private String employeePhone;
    private String employeeDateStart;
    private Double employeeSalary;
    private Boolean deleteFlag;

    public Employee() {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public Boolean getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(Boolean employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public String getEmployeeGmail() {
        return employeeGmail;
    }

    public void setEmployeeGmail(String employeeGmail) {
        this.employeeGmail = employeeGmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeDateStart() {
        return employeeDateStart;
    }

    public void setEmployeeDateStart(String employeeDateStart) {
        this.employeeDateStart = employeeDateStart;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountId")
    @JsonBackReference
    private Account account;

    @ManyToOne(targetEntity = Position.class)
    @JoinColumn(name = "positionId")
    private Position position;

    @JsonBackReference
    @OneToMany(mappedBy = "employee")
    public List<Contract> contractList;
}
