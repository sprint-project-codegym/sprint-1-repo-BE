package com.example.sprint_1.service.impl.ground;

import com.example.sprint_1.dto.ground.GroundCreateDTO;
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
        this.groundRepository.createGroundDTO(ground.getGroundId(), ground.getGroundType(), ground.getArea(),
                ground.getImage(), ground.getStatus(), ground.getRentCost(), ground.getManageCost(),
                ground.getNote(), ground.getVersion(), ground.getFloor().getFloorId());
    }

}
