package org.example.webstore.image;

import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ImageType {
    JPEG("image/jpeg"),
    PNG("image/png"),
    SVG("image/svg+xml"),
    ;

    private final String mimeType;

    public static boolean isValidImageType (@NotBlank String imageType) {
        for (var type : ImageType.values()) {
            if (type.mimeType.equals(imageType)) {
                return true;
            }
        }
        return false;
    }

    public static ImageType fromMimeType(@NotBlank String imageType) {
        for (var type : ImageType.values()) {
            if (type.mimeType.equals(imageType)) {
                return type;
            }
        }
        throw new IllegalArgumentException("unsupported image type: " + imageType);
    }
}
