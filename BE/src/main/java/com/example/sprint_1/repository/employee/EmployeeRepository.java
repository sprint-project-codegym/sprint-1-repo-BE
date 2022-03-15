package com.example.sprint_1.repository.employee;

import com.example.sprint_1.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    List<Employee> findAll();

    @Query(value= "insert into employee values (:employee_name,:employee_birthday,:employee_gender,:employee_id_card,:employee_email,:employee_address,:employee_phone,:employee_date_start,:employee_salary,'0')", nativeQuery=true)
    void addEmployee(@Param("employee_name") String employee_name, @Param("employee_birthday") String employee_birthday, @Param("employee_gender") Boolean employee_gender,
                     @Param("employee_id_card") String employee_id_card, @Param("employee_email")
            String employee_email,@Param("employee_address") String employee_address, @Param("employee_phone") String employee_phone,
                     @Param("employee_date_start") String employee_date_start, @Param("employee_salary") Double employee_salary);

    @Query(value= "update employee set employee_name=:employee_name,employee_birthday=:employee_birthday,employee_gender=:employee_gender,employee_id_card=:employee_id_card,employee_email=:employee_email,employee_address=:employee_address,employee_phone=:employee_phone,employee_date_start=:employee_date_start,employee_salary=:employee_salary,delete_flag=:delete_flag where employee_id=:id", nativeQuery=true)
    void editEmployee(@Param("employee_name") String employee_name, @Param("employee_birthday") String employee_birthday, @Param("employee_gender") Boolean employee_gender,
                     @Param("employee_id_card") String employee_id_card, @Param("employee_email")
                             String employee_email,@Param("employee_address") String employee_address, @Param("employee_phone") String employee_phone,
                     @Param("employee_date_start") String employee_date_start, @Param("employee_salary") Double employee_salary,@Param("id") Integer id);
}
