package com.example.sprint_1.repository.employee;

import com.example.sprint_1.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
<<<<<<< HEAD
    Employee findEmployeeByEmployeeId(String id);
=======
//    Employee findEmployeeById(String id);
>>>>>>> 3d2b27c42e637c107910d85f75dd36f344f0ee13

}
