package com.example.sprint_1.repository.ground;

import com.example.sprint_1.entity.ground.Ground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface GroundRepository extends JpaRepository<Ground, String> {
    @Query( value = "select g.ground_id, g.area, g.ground_type, g.image, g.status, g.rent_cost, g.manage_cost, g.note, g.version, g.delete_flag, g.floor_id from ground as g left join floor as f on g.floor_id = f.floor_id where g.ground_id = :id", nativeQuery = true)
    Ground  findByGroundId(@Param("id") String id);

    @Query( value = "select g.ground_id, g.area, g.ground_type, g.image, g.status, g.rent_cost, g.manage_cost, g.note, g.version, g.delete_flag, g.floor_id from ground as g left join floor as f on g.floor_id = f.floor_id", nativeQuery = true)
    List<Ground> findAll();

    @Transactional
    @Modifying
    @Query(value = "update ground g set g.ground_id = ?1, g.ground_type =?2, g.area =?3, g.image = ?4, g.status = ?5, g.rent_cost = ?6, g.manage_cost = ?7, g.note =?8, g.version =?9, g.floor_id =?10 where g.ground_id = ?11", nativeQuery = true)
    void updateGroundDTO(String groundId, String groundType, Double area, String image, String status,
                         Double rentCost, Double manageCost, String note, Integer version, String floorId, String id);
}
