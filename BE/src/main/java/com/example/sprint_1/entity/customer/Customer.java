package com.example.sprint_1.entity.customer;

import com.example.sprint_1.entity.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
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
    @JsonBackReference(value = "user_contract")
    public List<Contract> contractList;
}
