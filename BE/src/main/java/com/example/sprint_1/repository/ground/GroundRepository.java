package com.example.sprint_1.repository.ground;

import com.example.sprint_1.entity.ground.Ground;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public interface GroundRepository extends JpaRepository<Ground, String> {
    @Query(value = "select g.ground_id, g.area, g.ground_type, g.image, g.status, g.rent_cost, g.manage_cost, g.note, g.version, g.delete_flag, g.floor_id from ground as g left join floor as f on g.floor_id = f.floor_id where g.ground_id = :id", nativeQuery = true)
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
            countQuery = "select count(*) from customer where customer.customer_id like %?1% and customer.customer_name like %?2% and customer.delete_flag = 1", nativeQuery = true)
    Page<Ground> findByGroundIdContainingAndGroundTypeContaining(String id, String groundType, Pageable pageable);

}
