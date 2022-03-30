package com.example.sprint_1.repository.ground;

import com.example.sprint_1.entity.ground.Building;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BuildingRepository extends JpaRepository<Building, String> {
    //PhuocDD da code chuc nang nay de lay danh sach toa nha
    @Query(value="select building_id, address, building_name, email, fax, phone_number, tax_code from building", nativeQuery = true)
    Page<Building> findAllBuildingWithPagination(Pageable pageable);
}
