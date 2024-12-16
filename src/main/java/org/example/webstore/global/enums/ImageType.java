package org.example.webstore.global.enums;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ImageType implements EnumValueProvider {
    JPEG("image/jpeg"),
    PNG("image/png"),
    SVG("image/svg+xml"),
    ;

    private final String mimeType;

    @Override
    public String getEnumValue() {
        return mimeType;
    }

    @SneakyThrows
    public static boolean isValidImageType (@NotBlank String imageType) {
        return EnumValueProvider.fromValue(imageType, ImageType.values()) != null;
    }

    @SneakyThrows
    public static ImageType fromMimeType(@NotBlank String imageType) {
        var value = EnumValueProvider.fromValue(imageType, ImageType.values());
        if (value != null) {return value;}
        throw new IllegalArgumentException("Invalid image type: " + imageType);
    }
}
