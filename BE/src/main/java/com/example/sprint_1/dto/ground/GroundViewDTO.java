package com.example.sprint_1.dto.ground;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;

public interface GroundViewDTO {
    String getGroundId();
    String getGroundType();
    Double getArea();
    String getImage();
    String getStatus();
    Double getRentCost();
    Double getManageCost();
    String getNote();
    Integer getVersion();
    Boolean getDeleteFlag();
    String getFloorId();
}
