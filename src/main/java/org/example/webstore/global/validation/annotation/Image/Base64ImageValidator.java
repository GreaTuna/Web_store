package org.example.webstore.global.validation.annotation.Image;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Base64;
import org.example.webstore.image.ImageConfig;
import org.example.webstore.image.ImageType;
import org.example.webstore.image.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class Base64ImageValidator implements ConstraintValidator<Base64Image, String> {
    private int maxSize;
    @Autowired private ImageConfig imageConfig;

    @Override
    public void initialize(Base64Image constraintAnnotation) {
        this.maxSize = imageConfig.getMaxSizeInBytes();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        if (!ImageUtil.isBase64Image(value)) {
            return false;
        }

        var type = ImageUtil.extractBase64ImageType(value);
        if (!ImageType.isValidImageType(type)) {
            throw new IllegalArgumentException("Invalid image type: " + type);
        }
        var bytes = Base64.getDecoder().decode(ImageUtil.extractBase64ImagBytes(value));
        if(bytes.length > maxSize) {
            throw new IllegalArgumentException("Image size exceeds 10 Mb");
        }
        return true;
    }
}
