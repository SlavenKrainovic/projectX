package com.bilionDolarProject.projectX.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OptionalPositiveValidator implements ConstraintValidator<OptionalPositive, Double> {
    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        // Null or zero is valid (optional)
        if (value == null || value == 0) {
            return true;
        }
        // Only fail if negative
        return value > 0;
    }
}
