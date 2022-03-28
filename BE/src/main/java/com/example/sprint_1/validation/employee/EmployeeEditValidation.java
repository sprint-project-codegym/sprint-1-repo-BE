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
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"employeeName","employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"employeeBirthday","employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"employeeGender","employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"employeeGmail","employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"employeeIdCard","employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"employeeAddress","employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"employeePhone","employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"employeeSalary","employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"position.positionId","employee.empty");

        if (employeeDTO.getEmployeeName().equals("null")) {
            errors.rejectValue("employeeName", "name.null");
        }

        if(employeeDTO.getEmployeeIdCard().equals("null")){
            errors.rejectValue("employeeIdCard", "idCard.null");
        }

        if(employeeDTO.getEmployeeGmail().equals("null")){
            errors.rejectValue("employeeGmail", "email.null");
        }

        if(employeeDTO.getEmployeeAddress().equals("null")){
            errors.rejectValue("employeeAddress", "address.null");
        }

        if(employeeDTO.getEmployeeSalary()==null){
            errors.rejectValue("employeeSalary", "address.null");
        }

        if (!employeeDTO.getEmployeeName().matches("^[\\D]+$")) {
            errors.rejectValue("employeeName", "name.invalid");
        }

        if (employeeDTO.getEmployeeGender()==null) {
            errors.rejectValue("employeeGender","gender.null");
        }
        if (!(employeeDTO.getEmployeeGender().equals(true) || employeeDTO.getEmployeeGender().equals(false))) {
            errors.rejectValue("employeeGender","gender.null");
        }

        if (!employeeDTO.getEmployeePhone().startsWith("0")) {
            errors.rejectValue("employeePhone", "phone.invalid");
        }
        if (employeeDTO.getEmployeePhone().equals("null")) {
            errors.rejectValue("employeePhone", "phone.null");
        }

        if(!employeeDTO.getEmployeeGmail().matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")){
            errors.rejectValue("employeeGmail", "email.invalid");
        }
        if(employeeDTO.getEmployeeGmail().equals("null")){
            errors.rejectValue("employeeGmail", "email.null");
        }

        if(employeeDTO.getPosition().getPositionId().equals("null")){
            errors.rejectValue("position.positionId", "position.null");
        }

        if(!employeeDTO.getEmployeeIdCard().matches("^[\\d]{9}|[\\d]{12}$")){
            errors.rejectValue("employeeIdCard", "idCard.invalid");
        }

        if(!DateValidator.greaterThan18Year(employeeDTO.getEmployeeBirthday())){
            errors.rejectValue("employeeBirthday", "dateOfBirth.invalid");
        }

    }
}
