package com.example.SpringBoot.LearningSpringBoot.CustomAnnotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Constraint(validatedBy = {EmployeeRoleValidator.class})
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmployeeRoleValidation {
    String message() default "R0le of the employee can be USER OR ADMIN";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
