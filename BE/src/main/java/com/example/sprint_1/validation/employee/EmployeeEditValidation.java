package com.example.sprint_1.validation.employee;

import com.example.sprint_1.dto.employee.EmployeeDTO;
import com.example.sprint_1.validation.employee.custom.DateValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EmployeeEditValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return EmployeeDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDTO employeeDTO = (EmployeeDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "idCard", "employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salary", "employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "position", "employee.empty");
<<<<<<< HEAD
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "employee.empty");
=======
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "employee.empty");
>>>>>>> 72757406d8117924b4411b003cf435dbbb361414

        if (!employeeDTO.getName().matches("^[\\D]+$")) {
            errors.rejectValue("phone", "phone.startWith");
        }

        if (!employeeDTO.getPhone().startsWith("0")) {
            errors.rejectValue("phone", "phone.startWith");
        }

        if(!employeeDTO.getEmail().matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")){
            errors.rejectValue("email", "email.invalid");
        }

        if(!employeeDTO.getIdCard().matches("^[\\d]{9}|[\\d]{12}$")){
            errors.rejectValue("idCard", "idCard.invalid");
        }

        if(!DateValidator.greaterThan18Year(employeeDTO.getDateOfBirth())){
            errors.rejectValue("dateOfBirth", "dateOfBirth.invalid");
        }
    }
}
