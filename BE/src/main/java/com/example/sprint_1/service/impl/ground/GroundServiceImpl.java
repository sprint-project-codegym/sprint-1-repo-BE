package com.example.sprint_1.service.impl.ground;

import com.example.sprint_1.dto.ground.GroundDTO;
import com.example.sprint_1.entity.ground.Ground;
import com.example.sprint_1.repository.ground.GroundRepository;
import com.example.sprint_1.service.ground.GroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroundServiceImpl implements GroundService {
    @Autowired
    GroundRepository groundRepository;

    @Override
    public Ground getGroundByGroundId(String id) {
        return groundRepository.findByGroundId(id);
    }


    @Override
    public List<Ground> findAll() {
        return groundRepository.findAll();
    }

    //NghiaND - chỉnh sửa mặt bằng
    @Override
    public void updateGround(String id, GroundDTO ground) {
        groundRepository.updateGroundDTO(ground.getGroundId(), ground.getGroundType(),ground.getArea(),ground.getImage(),ground.getStatus(),ground.getRentCost(),ground.getManageCost(),ground.getNote(),ground.getVersion(),ground.getFloor().getFloorId(),id);

    }
}
