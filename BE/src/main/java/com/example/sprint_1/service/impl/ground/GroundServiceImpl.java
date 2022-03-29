package com.example.sprint_1.service.impl.ground;

import com.example.sprint_1.dto.ground.GroundViewDTO;
import com.example.sprint_1.entity.ground.Ground;
import com.example.sprint_1.repository.ground.GroundRepository;
import com.example.sprint_1.service.ground.GroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroundServiceImpl implements GroundService {
    @Autowired
    GroundRepository groundRepository;

    @Override
    public void save(Ground ground) {
        this.groundRepository.createGround(ground.getGroundId(), ground.getGroundType(), ground.getArea(),
                ground.getImage(), ground.getStatus(), ground.getRentCost(), ground.getManageCost(),
                ground.getNote(), ground.getVersion(), ground.getFloor().getFloorId(), ground.getDeleteFlag());
    }

    @Override
    public GroundViewDTO findGroundById(String id) {
        return this.groundRepository.findGroundById(id);
    }

}
