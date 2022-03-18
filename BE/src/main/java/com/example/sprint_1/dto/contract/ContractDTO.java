package com.example.sprint_1.dto.contract;

import com.example.sprint_1.dto.customer.CustomerDTO;
import com.example.sprint_1.dto.employee.EmployeeDTO;
import com.example.sprint_1.dto.ground.GroundDTO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ContractDTO {
    @Id
    @NotEmpty
    private String contractId;
    @Column(columnDefinition = "Date")
    @NotEmpty
    private String startDate;
    @NotEmpty
    @Column(columnDefinition = "Date")
    private String endDate;
    @NotEmpty
    @Column(columnDefinition = "Date")
    private String contractDate;
    @NotNull(message = "alo alo")
    private Double rentCost;
    @NotNull
    private Double totalCost;
    @NotEmpty
    private String contractContent;
    private Boolean deleteFlag;

    private CustomerDTO customer;

    private EmployeeDTO employee;

    private GroundDTO ground;

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public Double getRentCost() {
        return rentCost;
    }

    public void setRentCost(Double rentCost) {
        this.rentCost = rentCost;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public String getContractContent() {
        return contractContent;
    }

    public void setContractContent(String contractContent) {
        this.contractContent = contractContent;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }

    public GroundDTO getGround() {
        return ground;
    }

    public void setGround(GroundDTO ground) {
        this.ground = ground;
    }
}
