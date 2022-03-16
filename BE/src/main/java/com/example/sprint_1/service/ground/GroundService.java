package com.example.sprint_1.service.ground;

import com.example.sprint_1.entity.ground.Ground;

import java.util.List;

public interface GroundService {
    public Ground getGroundByGroundId(String groundId);
    public Ground save(Ground ground);
    public List<Ground> findAll();
    public Ground updateGround (String id, Ground ground);

}
