package com.example.sprint_1.dto.ground;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroundCreateDTO {
    String groundId;
    String groundType;
    Double area;
    String image;
    String status;
    Double rentCost;
    Double manageCost;
    String note;
    Integer version;
    String floorId;
}
