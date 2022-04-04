package com.example.sprint_1.repository.employee;

import com.example.sprint_1.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    Employee findEmployeeByEmployeeId(String id);

//    Employee findEmployeeById(String id);

    List<Employee> findAll();
    Employee findByEmployeeId(String id);

//    @Query(value= "insert into employee values (:employee_name,:employee_birthday,:employee_gender,:employee_id_card,:employee_email,:employee_address,:employee_phone,:employee_date_start,:employee_salary,'0')", nativeQuery=true)
//    void addEmployee(@Param("employee_name") String employee_name, @Param("employee_birthday") String employee_birthday, @Param("employee_gender") Boolean employee_gender,
//                     @Param("employee_id_card") String employee_id_card, @Param("employee_email")
//            String employee_email,@Param("employee_address") String employee_address, @Param("employee_phone") String employee_phone,
//                     @Param("employee_date_start") String employee_date_start, @Param("employee_salary") Double employee_salary);
//
//    @Query(value= "update employee set employee_name=:employee_name,employee_birthday=:employee_birthday,employee_gender=:employee_gender,employee_id_card=:employee_id_card,employee_email=:employee_email,employee_address=:employee_address,employee_phone=:employee_phone,employee_date_start=:employee_date_start,employee_salary=:employee_salary,delete_flag=:delete_flag where employee_id=:id", nativeQuery=true)
//    void editEmployee(@Param("employee_name") String employee_name, @Param("employee_birthday") String employee_birthday, @Param("employee_gender") Boolean employee_gender,
//                     @Param("employee_id_card") String employee_id_card, @Param("employee_email")
//                             String employee_email,@Param("employee_address") String employee_address, @Param("employee_phone") String employee_phone,
//                     @Param("employee_date_start") String employee_date_start, @Param("employee_salary") Double employee_salary,@Param("id") String id);

//    @Modifying
//    @Query(value = "INSERT INTO employee VALUES (:#{#employee.employeeId},:#{#employee.employeeName},:#{#employee.employeeBirthday},:#{#employee.employeeGender}," +
//            ":#{#employee.employeeIdCard},:#{#employee.employeeGmail},:#{#employee.employeeAddress},:#{#employee.employeePhone},:#{#employee.employeeSalary},:#{#employee.deleteFlag},:#{#employee.position},:#{#employee.account})", nativeQuery = true)
//    @Transactional
//    void createNewEmployee(Employee employee);

    @Modifying
    @Query(value="insert into employee(employee_id,employee_name,employee_birthday" +
            ",employee_gender,employee_id_card,employee_gmail,employee_address" +
            ",employee_phone,employee_salary,url_image,delete_flag" +
            ",account_id,position_id) values (?,?,?,?,?,?,?,?,?,?,?,?,?)",nativeQuery = true)
    @Transactional
    void createNewEmployee(String id,String name, String dateOfBirth, Boolean gender,String idCard,String email,
                           String address, String phone, Double salary,String employee_image,Boolean delete_flag,
                           Integer account,String position);

    @Modifying
    @Query(value="update employee set employee_name=?,employee_birthday=?" +
            ",employee_gender=?,employee_id_card=?,employee_gmail=?,employee_address=?" +
            ",employee_phone=?,employee_salary=?,url_image=?,delete_flag=?" +
            ",account_id=?,position_id=? where employee_id =?",nativeQuery = true)
    @Transactional
    void editEmployee(String name, String dateOfBirth, Boolean gender,String idCard,String email,
                      String address, String phone, Double salary,String employee_image,Boolean delete_flag,
                      Integer account,String position,String id);

//    @Modifying
//    @Query(value="insert into employee(employee_id,delete_flag,account_id,position_id)values (?,?,?,?)",nativeQuery = true)
//    @Transactional
//    void createNewEmployee(String id,Boolean delete_flag,Integer account,String position
//    );

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
