package com.example.sprint_1.dto.ground;

import lombok.*;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroundCreateDTO {

    @NotBlank(message = "Không được để trống!")
    @Pattern(regexp = "^(MB)[-][\\d]{4}$", message = "Mã mặt bằng không đúng định dạng (MB-xxxx)!")
    private String groundId;

    @NotBlank(message = "Không được để trống!")
    private String groundType;

    @NotNull(message = "Không được để trống!")
    @Min(value = 0, message = "Diện tích phải là số dương")
    private Double area;

    @NotBlank(message = "Không được để trống!")
    private String image;

    @NotBlank(message = "Không được để trống!")
    private String status;

    @NotNull(message = "Không được để trống!")
    @Min(value = 0, message = "Giá tiền thuê phải là số dương!")
    private Double rentCost;

    @NotNull(message = "Không được để trống!")
    @Min(value = 0, message = "Phí quản lý phải là số dương!")
    private Double manageCost;

    private String note;
    private Integer version;

    @NotBlank(message = "Không được để trống!")
    private String floorId;
}
