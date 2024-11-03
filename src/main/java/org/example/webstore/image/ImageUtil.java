package org.example.webstore.image;

import java.util.regex.Pattern;
import lombok.NonNull;

public class ImageUtil {
    private static final Pattern BASE64_IMAGE_PATTERN = Pattern.compile("data:image\\/[^;]+;base64[^\"]+");

    public static String extractBase64ImageType(@NonNull String image) {
        if (isBase64Image(image)) {
            int colonIndex = image.indexOf(":");
            int semicolonIndex = image.indexOf(";");
            return image.substring(colonIndex + 1, semicolonIndex);
        }
        throw new IllegalArgumentException("invalid string format");
    }

    public static String extractBase64ImagBytes(@NonNull String image) {
        if (isBase64Image(image)) {
            int index = image.indexOf(",");
            return image.substring(index + 1);
        }
        throw new IllegalArgumentException("invalid string format");
    }

    public static boolean isBase64Image(String value) {
        return BASE64_IMAGE_PATTERN.matcher(value).matches();
    }
}
