package com.example.sprint_1.dto.contract;

import com.example.sprint_1.dto.customer.CustomerDTO;
import com.example.sprint_1.dto.employee.EmployeeDTO;
import com.example.sprint_1.dto.ground.GroundDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ContractDTO {
    @Id
    @NotEmpty
    private String contractId;
    @Column(columnDefinition = "Date")
    @NotEmpty
    private String startDate;
    @Column(columnDefinition = "Date")
    @NotEmpty
    private String endDate;
    @Column(columnDefinition = "Date")
    @NotEmpty
    private String contractDate;
    @NotNull
    @DecimalMax("1000000000.0")
    @DecimalMin("10.0")
    private Double rentCost;
    @NotNull
    @DecimalMax("1000000000.0")
    @DecimalMin("10.0")
    private Double totalCost;
    @NotEmpty
    @Length(min = 5, max = 20)
    private String contractContent;

    private CustomerDTO customer;

    private EmployeeDTO employee;

    private GroundDTO ground;
}
