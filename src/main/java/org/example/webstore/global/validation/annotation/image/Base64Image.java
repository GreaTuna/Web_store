package org.example.webstore.global.validation.annotation.image;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER,  ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Base64ImageValidator.class)
public  @interface  Base64Image {
    String message() default "Invalid Base64 image";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
