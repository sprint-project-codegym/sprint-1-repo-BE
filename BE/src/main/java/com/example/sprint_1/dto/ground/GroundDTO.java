package com.example.sprint_1.dto.ground;

import lombok.*;

import javax.persistence.Id;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class GroundDTO {
    @Id
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
