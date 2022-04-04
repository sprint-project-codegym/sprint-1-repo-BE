package com.example.sprint_1.repository.ground;

import com.example.sprint_1.dto.ground.GroundViewDTO;
import com.example.sprint_1.entity.ground.Ground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Repository;

@Repository
public interface GroundRepository extends JpaRepository<Ground, String> {
    @Query(value = "select g.ground_id, g.area, g.ground_type, g.image, g.status, g.rent_cost, g.manage_cost, g.note, g.version, g.delete_flag, g.floor_id from ground as g left join floor as f on g.floor_id = f.floor_id where g.ground_id = :id and g.delete_flag = 1", nativeQuery = true)
    Ground findByGroundId(@Param("id") String id);

    @Transactional
    @Modifying
    @Query(value = "update ground g set g.ground_id = ?1, g.ground_type =?2, g.area =?3, g.image = ?4, g.status = ?5, g.rent_cost = ?6, g.manage_cost = ?7, g.note =?8, g.version =?9, g.floor_id =?10 where g.ground_id = ?11", nativeQuery = true)
    void updateGroundDTO(String groundId, String groundType, Double area, String image, String status,
                         Double rentCost, Double manageCost, String note, Integer version, String floorId, String id);

    @Query(value = "select g.ground_id, g.area, g.ground_type, g.image, g.status, g.rent_cost, g.manage_cost, g.note, g.version, g.delete_flag, g.floor_id from ground as g left join floor as f on g.floor_id = f.floor_id", nativeQuery = true)
    Page<Ground> findAll(Pageable page);

    @Modifying
    @Transactional
    @Query(value = "update ground set ground.delete_flag = 0 where ground.ground_id = :id", nativeQuery = true)
    void deleteByGroundId(@Param("id") String id);

    @Query(value = "select ground.ground_id, ground.area, ground.ground_type, ground.image, ground.status, ground.rent_cost, ground.manage_cost, ground.note, ground.version, ground.delete_flag, ground.floor_id " +
            "from ground left join floor on ground.floor_id = floor.floor_id where ground.ground_id like %?1% and ground.ground_type like %?2% and ground.delete_flag = 1",
            countQuery = "select count(*) from ground where ground.ground_id like %?1% and ground.ground_type like %?2% and ground.delete_flag = 1", nativeQuery = true)
    Page<Ground> findByGroundIdContainingAndGroundTypeContaining(String id, String groundType, Pageable pageable);

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
