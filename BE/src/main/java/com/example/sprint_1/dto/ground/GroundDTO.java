package com.example.sprint_1.dto.ground;

import lombok.Data;

import javax.persistence.Id;
@Data
public class GroundDTO {
    private String groundId;
    private String groundType;
    private Double area;
    private String image;
    private String status;
    private Double rentCost;
    private Double manageCost;
    private String note;
    private Integer version;
    private Boolean deleteFlag;

    private FloorDTO floor;
}
