package com.example.sprint_1.dto.customer;

import lombok.Data;

import javax.persistence.Id;

@Data
public class CustomerDTO {
    @Id
    private String customerId;
    private String customerName;
    private String customerBirthday;
    private String customerIdCard;
    private String customerEmail;
    private String customerAddress;
    private String customerPhone;
    private String customerCompany;
    private String status;
    private Boolean deleteFlag;

}