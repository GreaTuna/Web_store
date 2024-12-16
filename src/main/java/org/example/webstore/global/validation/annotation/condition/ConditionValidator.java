package org.example.webstore.global.validation.annotation.condition;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.webstore.global.enums.Condition;

public class ConditionValidator implements ConstraintValidator<ValidCondition, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return Condition.isValidCondition(value);
    }
}
