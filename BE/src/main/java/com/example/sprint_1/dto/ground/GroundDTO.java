package com.example.sprint_1.dto.ground;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class GroundDTO {
    @NotBlank(message = "Mã mặt bằng không được để trống!")
    @Pattern(regexp = "^(MB)[-][\\d]{4}$", message = "Mã mặt bằng không đúng định dạng (MB-xxxx)!")
    private String groundId;

    @NotBlank(message = "Loại mặt bằng không được để trống!")
    private String groundType;

    @NotNull(message = "Diện tích không được để trống!")
    @Min(value = 0, message = "Diện tích phải là số dương")
    private Double area;

    @NotBlank(message = "Hình ảnh không được để trống!")
    private String image;

    @NotBlank(message = "Trạng thái không được để trống!")
    private String status;

    @NotNull(message = "Giá tiền thuê không được để trống!")
    @Min(value = 0, message = "Giá tiền thuê phải là số dương!")
    private Double rentCost;

    @NotNull(message = "Phí quản lý không được để trống!")
    @Min(value = 0, message = "Phí quản lý phải là số dương!")
    private Double manageCost;
    private String note;
    private Integer version;
    private Boolean deleteFlag;
    @NotBlank(message = "Không được để trống!")
    private String floorId;
}
