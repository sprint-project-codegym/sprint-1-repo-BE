package com.example.sprint_1.service.impl.ground;

import com.example.sprint_1.entity.ground.Building;
import com.example.sprint_1.entity.ground.Floor;
import com.example.sprint_1.repository.ground.FloorRepository;
import com.example.sprint_1.service.ground.FloorService;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Service
public class FloorServiceImpl implements FloorService {
    // PhuocDD code chuc nang xoa tang

    @Autowired
    FloorRepository floorRepository;
    @PersistenceContext
    private EntityManager em;

    @Override
    public Page<Floor> findAllFloorWithPagination(Pageable pageable) {
        return floorRepository.findAllFloorWithPagination(pageable);
    }

    @Override
    public void deleteFloor(String id) {
        floorRepository.deleteFloor(id);
    }
}
