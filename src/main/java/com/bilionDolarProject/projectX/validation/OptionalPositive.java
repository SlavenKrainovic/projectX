package com.bilionDolarProject.projectX.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = OptionalPositiveValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OptionalPositive {
    String message() default "Value must not be negative";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
