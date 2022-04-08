package com.example.sprint_1.dto.ground;

import lombok.Data;

@Data
public class GroundContractDTO {
    private String groundId;
    private String groundType;
    private Double area;
    private String image;
    private String status;
    private Double rentCost;
    private FloorContractDTO floor;
}
