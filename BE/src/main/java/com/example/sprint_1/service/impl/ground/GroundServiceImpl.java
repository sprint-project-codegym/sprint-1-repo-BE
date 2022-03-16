package com.example.sprint_1.service.impl.ground;

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
    public Ground getGroundByGroundId(String groundId) {
        return groundRepository.findByGroundId(groundId);
    }

    @Override
    public Ground save(Ground ground) {
        return groundRepository.save(ground);
    }

    @Override
    public List<Ground> findAll() {
        return groundRepository.findAll();
    }

    @Override
    public Ground updateGround(String id, Ground groundRequest) {
        Ground ground = groundRepository.findByGroundId(id);
        ground.setGroundType(groundRequest.getGroundType());
        ground.setArea(groundRequest.getArea());
        ground.setFloor(groundRequest.getFloor());
        ground.setContractList(groundRequest.getContractList());
        ground.setDeleteFlag(groundRequest.getDeleteFlag());
        ground.setImage(groundRequest.getImage());
        ground.setManageCost(groundRequest.getManageCost());
        ground.setRentCost(groundRequest.getRentCost());
        ground.setNote(groundRequest.getNote());
        ground.setStatus(groundRequest.getStatus());
        ground.setVersion(groundRequest.getVersion());
        return groundRepository.save(ground);

    }
}
