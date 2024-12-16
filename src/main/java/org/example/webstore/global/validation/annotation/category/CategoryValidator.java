package org.example.webstore.global.validation.annotation.category;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.webstore.global.enums.Category;

public class CategoryValidator implements ConstraintValidator<ValidCategory, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return Category.isValidCategory(value);
    }
}
