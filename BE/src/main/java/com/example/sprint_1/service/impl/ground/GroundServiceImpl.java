package com.example.sprint_1.service.impl.ground;


import com.example.sprint_1.dto.ground.GroundDTO;

import com.example.sprint_1.entity.ground.Ground;
import com.example.sprint_1.repository.ground.GroundRepository;
import com.example.sprint_1.service.ground.GroundService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroundServiceImpl implements GroundService {

    @Autowired
    GroundRepository groundRepository;

    @Override
    public void updateGround(String id, GroundDTO ground) {
        groundRepository.updateGroundDTO(ground.getGroundId(), ground.getGroundType(), ground.getArea(), ground.getImage(), ground.getStatus(), ground.getRentCost(), ground.getManageCost(), ground.getNote(), ground.getVersion(), ground.getFloorId(), id);
    }
    @Override
    public Page<Ground> findALl(Pageable pageable) {
        return groundRepository.findAll(pageable);
    }

    @Override
    public void deleteGround(String id) {
        groundRepository.deleteByGroundId(id);
    }

    @Override
    public Ground findById(String id) {
        return groundRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Ground> findByIdAndGroundType(Pageable pageable, String id, String groundType) {
        return groundRepository.findByGroundIdContainingAndGroundTypeContaining(id, groundType,pageable);
    }
}
