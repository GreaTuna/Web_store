package org.example.webstore.global.validation.annotation.Image;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Base64;
import java.util.regex.Pattern;
import org.example.webstore.image.ImageType;

public class Base64ImageValidator implements ConstraintValidator<Base64Image, String> {
    private int maxSize;
    private static final Pattern BASE64_IMAGE_PATTERN = Pattern.compile("data:image\\/[^;]+;base64[^\"]+");

    @Override
    public void initialize(Base64Image constraintAnnotation) {
       this.maxSize = constraintAnnotation.maxSize();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        if (!isBase64Image(value)) {
            return false;
        }

        var type = extractType(value);
        if (!ImageType.isValidImageType(type)) {
            throw new IllegalArgumentException("Invalid image type: " + type);
        }
        var bytes = Base64.getDecoder().decode(value);
        if(bytes.length > maxSize) {
            throw new IllegalArgumentException("Image size exceeds 10 Mb");
        }
        return true;
    }

    private boolean isBase64Image(String value) {
        return BASE64_IMAGE_PATTERN.matcher(value).matches();
    }

    private String extractType(String value) {
        return value.substring(value.indexOf(",") + 1);
    }
}
