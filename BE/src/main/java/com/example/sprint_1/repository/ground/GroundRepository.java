package com.example.sprint_1.repository.ground;

import com.example.sprint_1.entity.ground.Ground;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface GroundRepository extends JpaRepository<Ground, String> {
    @Query( value = "select g.ground_id, g.area, g.ground_type, g.image, g.status, g.rent_cost, g.manage_cost, g.note, g.version, g.delete_flag, g.floor_id from ground as g left join floor as f on g.floor_id = f.floor_id", nativeQuery = true)
    List<Ground> findAll();

    @Modifying
    @Transactional
    @Query(value = "delete from ground as g where g.ground_id = :id", nativeQuery = true)
    void deleteByGroundId(@Param("id") String id);
    @Query( value = "select g.ground_id, g.area, g.ground_type, g.image, g.status, g.rent_cost, g.manage_cost, g.note, g.version, g.delete_flag, g.floor_id from ground as g left join floor as f on g.floor_id = f.floor_id where g.ground_id like :id and g.ground_type like :groundType", nativeQuery = true)
    List<Ground> findByGroundIdContainingAndGroundTypeContaining(@Param("id") String id, @Param("groundType") String groundType);
    @Query( value = "select g.ground_id, g.area, g.ground_type, g.image, g.status, g.rent_cost, g.manage_cost, g.note, g.version, g.delete_flag, g.floor_id from ground as g left join floor as f on g.floor_id = f.floor_id where g.ground_id like :id", nativeQuery = true)
    List<Ground> findByGroundIdContaining(String id);

    @Query( value = "select g.ground_id, g.area, g.ground_type, g.image, g.status, g.rent_cost, g.manage_cost, g.note, g.version, g.delete_flag, g.floor_id from ground as g left join floor as f on g.floor_id = f.floor_id where g.ground_type like :groundType", nativeQuery = true)
    List<Ground> findByGroundTypeContaining(String groundType);
}
