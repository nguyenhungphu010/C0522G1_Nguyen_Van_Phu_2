package com.validation;

import com.dto.CustomerDto;
import org.springframework.validation.Errors;

import java.time.LocalDate;
import java.time.Period;

public class TimeValidation {

    public static void checkAge(CustomerDto customerDto, Errors errors) {
        try {
            String dateOfBirth = customerDto.getDayOfBirth();
            LocalDate ageLocalDate = LocalDate.parse(dateOfBirth);
            int checkAge = Period.between(ageLocalDate, LocalDate.now()).getYears();
            if (checkAge < 18 || checkAge > 80) {
                errors.rejectValue("dayOfBirth", "", "age < 18 or age > 80");
            }
        } catch (Exception e) {
            errors.rejectValue("dayOfBirth", "", "please input date");
        }


    }
}
