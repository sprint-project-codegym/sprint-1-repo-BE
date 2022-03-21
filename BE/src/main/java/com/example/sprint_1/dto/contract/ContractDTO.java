package com.example.sprint_1.dto.contract;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDTO {

    private String contractId;
    private String startDate;
    private String endDate;
    private String contractDate;
    private Double rentCost;
    private Double totalCost;
    private String contractContent;
    private Boolean deleteFlag;

    private String customerId;
    private String employeeId;
    private String groundId;

    @Override
    public String toString() {
        return "ContractDTO{" +
                "contractId='" + contractId + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", contractDate='" + contractDate + '\'' +
                ", rentCost=" + rentCost +
                ", totalCost=" + totalCost +
                ", contractContent='" + contractContent + '\'' +
                ", deleteFlag=" + deleteFlag +
                ", customerId='" + customerId + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", groundId='" + groundId + '\'' +
                '}';
    }
}
