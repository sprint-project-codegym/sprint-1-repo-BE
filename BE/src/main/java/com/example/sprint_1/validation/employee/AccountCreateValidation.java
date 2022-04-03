package com.example.sprint_1.validation.employee;

import com.example.sprint_1.dto.employee.AccountDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AccountCreateValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return AccountDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AccountDTO accountDTO = (AccountDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username","employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","employee.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","employee.empty");

        if(accountDTO.getUsername()==null){
            errors.rejectValue("username", "username.null");
        }

        if(accountDTO.getEmail()==null){
            errors.rejectValue("email", "email.null");
        }

        if(accountDTO.getPassword()==null){
            errors.rejectValue("password", "password.null");
        }
    }
}
