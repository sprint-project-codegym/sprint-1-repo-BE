package com.example.sprint_1.service.impl.ground;

import com.example.sprint_1.entity.ground.Ground;
import com.example.sprint_1.repository.ground.GroundRepository;
import com.example.sprint_1.service.ground.GroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroundServiceImpl implements GroundService {

    @Autowired
    GroundRepository groundRepository;

    private List<Ground> filterGround(List<Ground> grounds) {
        List<Ground> groundsTemp = new ArrayList<>();
        for (Ground ground : grounds) {
            if(ground.getDeleteFlag()) {
                groundsTemp.add(ground);
            }
        }
        return groundsTemp;
    }
    @Override
    public List<Ground> findALl() {
        List<Ground> grounds = groundRepository.findAll();
        return filterGround(grounds);
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
        List<Ground> grounds = groundRepository.findByGroundIdContainingAndGroundTypeContaining(id,groundType);
        return filterGround(grounds);
    }

    @Override
    public List<Ground> findByIdContaining(String id) {
        List<Ground> grounds = groundRepository.findByGroundIdContaining(id);
        return filterGround(grounds);
    }

    @Override
    public List<Ground> findByGroundType(String groundType) {
        List<Ground> grounds = groundRepository.findByGroundTypeContaining(groundType);
        return filterGround(grounds);
    }
}
