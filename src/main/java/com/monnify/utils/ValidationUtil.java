package com.monnify.utils;

import com.monnify.exceptions.MonnifyValidationException;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;


import java.util.Set;

public class ValidationUtil {
    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    public static <T> void validate(T requestObject) {
        Set<ConstraintViolation<T>> violations = validator.validate(requestObject);

        if (!violations.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder("Validation errors:");
            violations.forEach(violation ->
                    errorMessage.append("\n").append(violation.getMessage()));
            throw new MonnifyValidationException(errorMessage.toString());
        }
    }
}
