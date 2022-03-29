package com.example.sprint_1.repository.ground;

import com.example.sprint_1.dto.ground.GroundViewDTO;
import com.example.sprint_1.entity.ground.Ground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface GroundRepository extends JpaRepository<Ground, String> {
    //LuanVT: add new ground
    @Transactional
    @Modifying
    @Query(value = "insert into ground(ground_id, ground_type, area, image, status, rent_cost, manage_cost, note, version, " +
            "floor_id, delete_flag) values (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11)", nativeQuery = true)
    void createGround(String groundId, String groundType, Double area, String image, String status,
                      Double rentCost, Double manageCost, String note, Integer version, String floorId, Boolean deleteFlag);

    @Query(value = "select g.ground_id as groundId, g.area, g.ground_type as groundType, g.image, g.status, g.rent_cost as " +
            "rentCost, g.manage_cost as manageCost, g.note, g.version, g.delete_flag as deleteFlag, g.floor_id as floorId " +
            "from ground as g left join floor as f on g.floor_id = f.floor_id where g.ground_id = :id", nativeQuery = true)
    GroundViewDTO findGroundById(@Param("id") String id);
}
