package com.example.sprint_1.service.impl.ground;

import com.example.sprint_1.dto.ground.FloorListDTO;
import com.example.sprint_1.repository.ground.FloorRepository;
import com.example.sprint_1.service.ground.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorServiceImpl implements FloorService {
    @Autowired
    FloorRepository floorRepository;

    @Override
    public List<FloorListDTO> getAllFloor() {
        return this.floorRepository.findAllFloorDTO();
    }
}
