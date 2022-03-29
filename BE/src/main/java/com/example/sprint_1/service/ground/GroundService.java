package com.example.sprint_1.service.ground;

import com.example.sprint_1.dto.ground.GroundViewDTO;
import com.example.sprint_1.entity.ground.Ground;

public interface GroundService {
    void save(Ground ground);

    GroundViewDTO findGroundById(String id);
}
