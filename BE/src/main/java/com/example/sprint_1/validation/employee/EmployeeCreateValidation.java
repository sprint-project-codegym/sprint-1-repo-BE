package com.example.sprint_1.validation.employee;

import com.example.sprint_1.dto.employee.EmployeeDTO;
import com.example.sprint_1.validation.employee.custom.DateValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EmployeeCreateValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return EmployeeDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDTO employeeDTO = (EmployeeDTO) target;
<<<<<<< HEAD
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id","employee.empty");
=======
>>>>>>> 72757406d8117924b4411b003cf435dbbb361414
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"dateOfBirth","employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"gender","employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"idCard","employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"address","employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"phone","employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"salary","employee.empty");
<<<<<<< HEAD
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"position","employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username","employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","employee.empty");

        if (!employeeDTO.getName().matches("^[\\D]+$")) {
            errors.rejectValue("phone", "phone.invalid");
=======
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"position.positionId","employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"account.username","employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"account.password","employee.empty");

        if (employeeDTO.getName().equals("null")) {
            errors.rejectValue("name", "name.null");
        }

        if(employeeDTO.getIdCard().equals("null")){
            errors.rejectValue("idCard", "idCard.null");
        }

        if(employeeDTO.getEmail().equals("null")){
            errors.rejectValue("email", "email.null");
        }

        if(employeeDTO.getAddress().equals("null")){
            errors.rejectValue("address", "address.null");
        }

        if(employeeDTO.getSalary().equals("null")){
            errors.rejectValue("salary", "address.null");
        }

        if (!employeeDTO.getName().matches("^[\\D]+$")) {
            errors.rejectValue("name", "name.invalid");
>>>>>>> 72757406d8117924b4411b003cf435dbbb361414
        }

        if (!employeeDTO.getPhone().startsWith("0")) {
            errors.rejectValue("phone", "phone.invalid");
        }
<<<<<<< HEAD
=======
        if (employeeDTO.getPhone().equals("null")) {
            errors.rejectValue("phone", "phone.null");
        }
>>>>>>> 72757406d8117924b4411b003cf435dbbb361414

        if(!employeeDTO.getEmail().matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")){
            errors.rejectValue("email", "email.invalid");
        }
<<<<<<< HEAD
=======
        if(employeeDTO.getEmail().equals("null")){
            errors.rejectValue("email", "email.null");
        }

        if(employeeDTO.getPosition().getPositionId().equals("null")){
            errors.rejectValue("position.positionId", "position.null");
        }

        if(employeeDTO.getAccount().getUsername().equals("null")){
            errors.rejectValue("account.username", "username.null");
        }
>>>>>>> 72757406d8117924b4411b003cf435dbbb361414

        if(!employeeDTO.getIdCard().matches("^[\\d]{9}|[\\d]{12}$")){
            errors.rejectValue("idCard", "idCard.invalid");
        }

        if(!DateValidator.greaterThan18Year(employeeDTO.getDateOfBirth())){
            errors.rejectValue("dateOfBirth", "dateOfBirth.invalid");
        }

<<<<<<< HEAD
        if(!employeeDTO.getIdCard().matches("^[\\w]{6,32}$")){
            errors.rejectValue("idCard", "idCard.invalid");
=======
        if(!employeeDTO.getAccount().getPassword().matches("^[\\w]{6,32}$")){
            errors.rejectValue("account.password", "idCard.invalid");
>>>>>>> 72757406d8117924b4411b003cf435dbbb361414
        }
    }
}
