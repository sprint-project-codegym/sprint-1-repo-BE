package com.example.sprint_1.service.ground;

import com.example.sprint_1.dto.ground.GroundDTO;
import com.example.sprint_1.entity.ground.Ground;

import java.util.List;

public interface GroundService {
     Ground getGroundByGroundId(String id);
     List<Ground> findAll();
     void updateGround(String id, GroundDTO groundDTO);

}
