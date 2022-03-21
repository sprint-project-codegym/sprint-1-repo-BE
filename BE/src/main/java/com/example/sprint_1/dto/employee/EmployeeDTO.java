package com.example.sprint_1.dto.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

<<<<<<< HEAD
=======
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

>>>>>>> 72757406d8117924b4411b003cf435dbbb361414
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
<<<<<<< HEAD
    String id;
=======
>>>>>>> 72757406d8117924b4411b003cf435dbbb361414
    String name;
    String dateOfBirth;
    String gender;
    String email;
    String idCard;
    String address;
    String phone;
<<<<<<< HEAD
    Double salary;
    String position;
    String username;
    String password;
=======
    String salary;
    PositionDTO position;
    AccountDTO account;
>>>>>>> 72757406d8117924b4411b003cf435dbbb361414
}