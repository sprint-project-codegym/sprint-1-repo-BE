package com.example.sprint_1.dto.contract;

import com.example.sprint_1.dto.customer.CustomerDTO;
import com.example.sprint_1.dto.employee.EmployeeDTO;
import com.example.sprint_1.dto.ground.GroundDTO;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Data
public class ContractEditDto {
    @Id
    @NotBlank(message = "Không được để trống!")
    @Pattern(regexp = "^(HD)[-][\\d]{4}$", message = "Mã hợp đồng không đúng định dạng (HD-xxxx)!")
    private String contractId;
    @Column(columnDefinition = "Date")
    @NotEmpty(message = "Không được để trống!")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Ngày không hợp lệ")
    private String startDate;
    @Column(columnDefinition = "Date")
    @NotEmpty(message = "Không được để trống!")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Ngày không hợp lệ")
    private String endDate;
    @Column(columnDefinition = "Date")
    @NotEmpty(message = "Không được để trống!")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Ngày không hợp lệ")
    private String contractDate;
    @NotNull
    @DecimalMin(value = "0.0", message = "Giá tiền thuê phải là số dương!")
    private Double rentCost;
    @NotNull
    @DecimalMin(value = "0.0", message = "Tổng tiền thuê phải là số dương!")
    private Double totalCost;
    @NotEmpty(message = "Không được để trống!")
    @Length(message = "Giá tiền thuê phải là số dương!")
    private String contractContent;
    private Boolean deleteFlag;

    private CustomerDTO customer;

    private EmployeeDTO employee;

    private GroundDTO ground;
}
