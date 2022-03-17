package com.example.sprint_1.repository.employee;

import com.example.sprint_1.entity.employee.Employee;
import com.example.sprint_1.entity.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Query(value= "select * from employee",nativeQuery = true)
    List<Employee> getAllEmployee();

    @Query(value= "select * from employe where employee_id=:id",nativeQuery = true)
    Employee getEmployeeById(@Param("id")String id);

    @Modifying
    @Transactional
    @Query(value= "update employee set employee.delete_flag = 0 where employee_id=?1",nativeQuery = true)
    void deleteEmployee(String id);

    @Query(value= "select * from employee where employee_id like %?1% and employee_name like %?2%",nativeQuery = true)
    List<Employee> searchEmployee( String id, String name);

    @Query(value = "select employee.employee_id, employee.employee_name from employee \n" +
            "where employee.employee_name like ?1 and employee.employee_id like ?2 and employee.delete_flag = false ", nativeQuery = true)
    List<Employee> findEmployeeByIdAndName(String name, String id);

}
