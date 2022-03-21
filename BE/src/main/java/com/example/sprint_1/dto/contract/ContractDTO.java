package com.example.sprint_1.dto.contract;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.apache.bcel.ExceptionConstants;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDTO {
    @NotBlank(message = "Không được để trống!")
    @Pattern(regexp = "^(HD)[-][\\d]{4}$", message = "Mã hợp đồng không đúng định dạng (HD-xxxx)!")
    private String contractId;
    @NotBlank(message = "Không được để trống!")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Ngày không hợp lệ")
    private String startDate;
    @NotBlank(message = "Không được để trống!")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Ngày không hợp lệ")
    private String endDate;
    @NotBlank(message = "Không được để trống!")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Ngày không hợp lệ")
    private String contractDate;
    @NotNull(message = "Không được để trống!")
    @Min(value = 0, message = "Giá tiền thuê phải là số dương!")
    private Double rentCost;
    @NotNull(message = "Không được để trống!")
    @Min(value = 0, message = "Giá tiền thuê phải là số dương!")
    private Double totalCost;
    private String contractContent;
    private Boolean deleteFlag;

    private String customerId;
    private String employeeId;
    private String groundId;

    @Override
    public String toString() {
        return "ContractDTO{" +
                "contractId='" + contractId + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", contractDate='" + contractDate + '\'' +
                ", rentCost=" + rentCost +
                ", totalCost=" + totalCost +
                ", contractContent='" + contractContent + '\'' +
                ", deleteFlag=" + deleteFlag +
                ", customerId='" + customerId + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", groundId='" + groundId + '\'' +
                '}';
    }
}
