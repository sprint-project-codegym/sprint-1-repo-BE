package com.example.sprint_1.entity.contract;

import com.example.sprint_1.entity.customer.Customer;
import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.entity.ground.Ground;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "contract")
public class Contract {
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

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employeeId")
    private Employee employee;

    @ManyToOne(targetEntity = Ground.class)
    @JoinColumn(name = "groundId")
    private Ground ground;
}
