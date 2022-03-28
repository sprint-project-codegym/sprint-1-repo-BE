package com.example.sprint_1.entity.contract;

import com.example.sprint_1.entity.customer.Customer;
import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.entity.ground.Ground;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;

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
    @Length(min = 10, max = 200)
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
