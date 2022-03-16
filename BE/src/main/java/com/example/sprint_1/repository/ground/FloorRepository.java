package com.example.sprint_1.repository.ground;

import com.example.sprint_1.entity.ground.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface FloorRepository extends JpaRepository<Floor, String> {
    //PhuocDD da code chuc nang nay de lay danh sach tang
    @Query(value="select floor_id, area, capacity, delete_flag, floor_name, floor_type, status, building_id from floor", nativeQuery = true)
    List<Floor> findAllFloor();

    //PhuocDD da code chuc nang nay de lay floor ID
    @Query(value="select floor_id, area, capacity, delete_flag, floor_name, floor_type, status, building_id from floor where floor_id = :id", nativeQuery = true)
    Floor findFloorByFloorId(@Param("id") String id);

    //PhuocDD da code chuc nang nay de xoa tang
    @Modifying
    @Transactional
    @Query(value = "update floor set delete_flag = 0 where floor_id = :id",nativeQuery = true)
    void deleteFloor (@Param("id") String id);


}
