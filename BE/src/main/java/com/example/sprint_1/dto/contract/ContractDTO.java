package com.example.sprint_1.dto.contract;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
