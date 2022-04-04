package com.example.sprint_1.service.ground;

import com.example.sprint_1.entity.ground.Building;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BuildingService {
    Page<Building> findAllBuildingWithPagination(Pageable pageable);
}
