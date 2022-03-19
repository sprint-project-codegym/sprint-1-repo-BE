package com.example.sprint_1.dto.contract;

import com.example.sprint_1.dto.customer.CustomerDTO;
import com.example.sprint_1.dto.employee.EmployeeDTO;
import com.example.sprint_1.dto.ground.GroundDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
public class ContractDTO {
    @Id
    private String contractId;
    private String startDate;
    private String endDate;
    private String contractDate;
    private Double rentCost;
    private Double totalCost;
    private String contractContent;
    private Boolean deleteFlag;

    private CustomerDTO customer;

    private EmployeeDTO employee;

    private GroundDTO ground;
}
