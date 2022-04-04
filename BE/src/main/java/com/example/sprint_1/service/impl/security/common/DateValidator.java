package com.example.sprint_1.service.impl.security.common;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateValidator implements ConstraintValidator<DateValid, String>{
    @Override
    public void initialize(DateValid constraint) {
        // TODO document why this method is empty
    }
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            LocalDate date = LocalDate.parse(value, DateTimeFormatter.ISO_LOCAL_DATE);
            return date.plusDays(1).isBefore(LocalDate.now());
        } catch (Exception e){
            return false;
        }

    }
}
