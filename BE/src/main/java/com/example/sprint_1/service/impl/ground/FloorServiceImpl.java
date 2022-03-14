package com.example.sprint_1.service.impl.ground;

import com.example.sprint_1.entity.ground.Building;
import com.example.sprint_1.entity.ground.Floor;
import com.example.sprint_1.repository.ground.FloorRepository;
import com.example.sprint_1.service.ground.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FloorServiceImpl implements FloorService {
    @Autowired
    FloorRepository floorRepository;

    @Override
    public Page<Floor> findAllFloorWithPaginationn(Pageable pageable) {
        return floorRepository.findAllFloorWithPaginationn(pageable);
    }

    @Override
    public void deleteFloor(String id) {
        floorRepository.deleteFloor(id);
    }
}
