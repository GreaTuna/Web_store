package org.example.webstore.global.validation.annotation.Image;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Base64;
import org.example.webstore.global.exception.IllegalImageTypeException;
import org.example.webstore.image.ImageConfig;
import org.example.webstore.image.ImageType;
import org.example.webstore.image.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class Base64ImageValidator implements ConstraintValidator<Base64Image, String> {
    @Autowired
    private ImageConfig imageConfig;

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
            throw new IllegalImageTypeException("forbidden image type: " + type.substring(type.indexOf('/') + 1));
        }
        var bytes = Base64.getDecoder().decode(ImageUtil.extractBase64ImagBytes(value));
        if(bytes.length > imageConfig.getMaxSizeInBytes()) {
            throw new IllegalArgumentException("Image size exceeds " + imageConfig.getMaxSize() + " Mb");
        }
        return true;
    }
}
