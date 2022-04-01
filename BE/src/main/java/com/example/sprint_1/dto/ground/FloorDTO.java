package com.example.sprint_1.dto.ground;

import lombok.Data;

@Data
public class FloorDTO {
    private String floorId;
    private String floorName;
    private Double area;
    private Integer capacity;
    private String status;
    private String floorType;
    private Boolean deleteFlag;

    private BuildingDTO building;
}
