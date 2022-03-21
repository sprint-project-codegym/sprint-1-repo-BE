package com.example.sprint_1.dto.employee;

import lombok.Data;

@Data
public class PositionDTO {
    private String positionId;
    private String positionName;

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
