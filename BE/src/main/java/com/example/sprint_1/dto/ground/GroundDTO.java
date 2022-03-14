package com.example.sprint_1.dto.ground;

import com.example.sprint_1.entity.ground.Floor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class GroundDTO {

    @NotBlank(message = " Mã mặt bằng không được để trống")
    @Pattern(regexp = "(MB)[-][\\d]{4}", message = "Mã mặt bằng không đúng định dạng (MB-xxxx)")
    private String groundId;

    @NotBlank(message = " Loại mặt bằng không được để trống")
    private String groundType;

    @NotBlank(message = " Diện tích không được để trống")
    @Min(value = 0,message = "Diện tích phải là số dương")
    private Double area;

    private String image;

    @NotBlank(message = " Trạng thái không được để trống")
    private String status;

    @NotBlank(message = " Tiền thuê không được để trống")
    @Min(value = 0,message = "Tiền thuê phải là số dương")
    private Double rentCost;

    @NotBlank(message = " Phí quản lý không được để trống")
    @Min(value = 0,message = "Phí quản lý phải là số dương")
    private Double manageCost;
    private String note;
    private Integer version;
    private Boolean deleteFlag;
    private Floor floor;
}
