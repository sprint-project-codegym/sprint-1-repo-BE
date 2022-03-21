package com.example.sprint_1.dto.ground;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BuildingDTO {
    private String buildingId;
    private String buildingName;
    private String taxCode;
    private String phoneNumber;
    private String fax;
    private String email;
    private String address;

}
