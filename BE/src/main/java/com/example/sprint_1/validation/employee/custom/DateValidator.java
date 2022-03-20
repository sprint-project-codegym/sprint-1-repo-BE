package com.example.sprint_1.validation.employee.custom;

import java.time.LocalDate;
import java.time.Period;

public class DateValidator {
    public static boolean greaterThan18Year(String dateInput){
        try {
            String[] dateStr = dateInput.split("-");
            int year = Integer.parseInt(dateStr[0]);
            int month = Integer.parseInt(dateStr[1]);
            int day = Integer.parseInt(dateStr[2]);

            if(Integer.toString(year).length()!=4) return false;

            LocalDate currentDate = LocalDate.now();
            LocalDate myDate = LocalDate.of(year,month,day);
            return Period.between(myDate, currentDate).getYears() >= 18;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(greaterThan18Year("20-09-30"));
    }
}
