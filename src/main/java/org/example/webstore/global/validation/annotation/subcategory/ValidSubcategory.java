package org.example.webstore.global.validation.annotation.subcategory;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SubcategoryValidator.class)
public @interface ValidSubcategory {
    String message() default "Invalid subcategory";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
