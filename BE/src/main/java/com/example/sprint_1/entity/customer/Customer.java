package com.example.sprint_1.entity.customer;

import com.example.sprint_1.entity.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "customer")
public class Customer {
    @Id
    private String customerId;
    private String customerName;
    @Column(columnDefinition = "Date")
    private String customerBirthday;
    private String customerIdCard;
    private String customerEmail;
    private String customerAddress;
    private String customerPhone;
    private String customerCompany;
    private String status;
    private Boolean deleteFlag;

    @OneToMany(mappedBy = "customer")
    @JsonBackReference
    public List<Contract> contractList;
}
