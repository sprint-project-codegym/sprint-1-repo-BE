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
    public List<Ground> findALl() {
        return groundRepository.findAll();
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
    public List<Ground> findByIdAndGroundType(String id, String groundType) {
        return groundRepository.findByGroundIdContainingAndGroundTypeContaining(id,groundType);
    }

    @Override
    public List<Ground> findByIdContaining(String id) {
        return groundRepository.findByGroundIdContaining(id);
    }

    @Override
    public List<Ground> findByGroundType(String groundType) {
        return groundRepository.findByGroundTypeContaining(groundType);
    }
}
