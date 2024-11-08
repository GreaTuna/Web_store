package org.example.webstore.global.validation.annotation.Image;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Base64ImageValidator.class)
public  @interface  Base64Image {
    String message() default "Invalid Base64 image";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    int maxSize() default 10485760;
}
