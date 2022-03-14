package com.example.sprint_1.repository.ground;

import com.example.sprint_1.entity.ground.Ground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface GroundRepository extends JpaRepository<Ground, String> {
    //LuanVT: add new ground
    @Transactional
    @Modifying
    @Query(value = "insert into ground(ground_id, ground_type, area, image, status, rent_cost, manage_cost, note, version, floor_id) " +
            "values (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10)", nativeQuery = true)
    void createGroundDTO(String groundId, String groundType, Double area, String image, String status,
                         Double rentCost, Double manageCost, String note, Integer version, String floorId);
}
