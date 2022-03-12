package com.example.sprint_1.entity.contract;

import com.example.sprint_1.entity.customer.Customer;
import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.entity.ground.Ground;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "contract")
public class Contract {
    @Id
    private String contractId;
    @Column(columnDefinition = "Date")
    private String startDate;
    @Column(columnDefinition = "Date")
    private String endDate;
    @Column(columnDefinition = "Date")
    private String contractDate;
    private Double rentCost;
    private Double totalCost;
    private String contractContent;
    private Boolean deleteFlag;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    @JsonBackReference
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
    @JsonBackReference
    private Employee employee;

    @ManyToOne(targetEntity = Ground.class)
    @JoinColumn(name = "groundId")
    private Ground ground;
}
