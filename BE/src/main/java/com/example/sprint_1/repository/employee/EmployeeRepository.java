package com.example.sprint_1.repository.employee;

import com.example.sprint_1.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Query(value= "select employee.employee_id, employee.employee_name, employee.employee_birthday, employee.employee_gender, employee.employee_id_card, employee.employee_gmail, \n" +
            "employee.employee_address, employee.employee_phone, employee.employee_salary, employee.account_id, employee.position_id, employee.delete_flag, employee.url_image \n" +
            "from employee where delete_flag = false ",
            countQuery= "select count(*) " +
                    "from employee where delete_flag = false",nativeQuery = true)
    Page<Employee> getAllEmployee(Pageable pageable);

    @Query(value= "select employee.employee_id, employee.employee_name, employee.employee_birthday, employee.employee_gender, employee.employee_id_card, employee.employee_gmail, \n" +
            "employee.employee_address, employee.employee_phone, employee.employee_salary, employee.account_id, employee.position_id, employee.delete_flag, employee.url_image \n" +
            "from employee \n" +
            "where delete_flag = false and employee_id=?1 ",nativeQuery = true)
    Employee getEmployeeById(String id);

    @Modifying
    @Transactional
    @Query(value= "update employee set employee.delete_flag = true where employee_id=?1",nativeQuery = true)
    void deleteEmployee(String id);

    @Query(value = "select employee.employee_id, employee.employee_name, employee.employee_birthday, employee.employee_gender, employee.employee_id_card, employee.employee_gmail, \n" +
            "employee.employee_address, employee.employee_phone, employee.employee_salary, employee.account_id, employee.position_id, employee.delete_flag, employee.url_image \n" +
            "from employee where employee.employee_name like %?1% and employee.employee_id like %?2% \n" +
            "and employee.delete_flag = false ",
            countQuery= "select count(*) " +
                    "from employee where employee.employee_name like %?1% and employee.employee_id like %?2% and delete_flag = false",nativeQuery = true)
    Page<Employee> findEmployeeByIdAndName(Pageable pageable, String name, String id);

}
