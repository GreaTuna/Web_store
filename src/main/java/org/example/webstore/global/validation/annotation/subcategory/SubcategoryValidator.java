package org.example.webstore.global.validation.annotation.subcategory;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.webstore.global.enums.Subcategory;

public class SubcategoryValidator implements ConstraintValidator<ValidSubcategory, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Subcategory.isValidSubcategory(value);
    }
}
