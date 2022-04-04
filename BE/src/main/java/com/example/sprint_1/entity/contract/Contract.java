package com.example.sprint_1.entity.contract;

import com.example.sprint_1.entity.customer.Customer;
import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.entity.ground.Ground;

import javax.persistence.*;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Data
@Entity(name = "contract")
public class Contract {
    @Id
    @NotNull
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
