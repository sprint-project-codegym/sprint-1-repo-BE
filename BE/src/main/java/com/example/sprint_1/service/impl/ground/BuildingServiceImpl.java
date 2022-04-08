package com.example.sprint_1.service.impl.ground;

import com.example.sprint_1.entity.ground.Building;
import com.example.sprint_1.repository.ground.BuildingRepository;
import com.example.sprint_1.service.ground.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service

public class BuildingServiceImpl implements BuildingService {
    @Autowired
    BuildingRepository buildingRepository;

    @Override
    public Page<Building> findAllBuildingWithPagination(Pageable pageable) {
        return buildingRepository.findAllBuildingWithPagination(pageable);
    }
}
