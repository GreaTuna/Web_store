package org.example.webstore.image;

import java.util.regex.Pattern;
import lombok.NonNull;

public class ImageUtil {
    private static final Pattern BASE64_IMAGE_PATTERN = Pattern.compile("data:image\\/[^;]+;base64[^\"]+");
    private static final String url = System.getenv().getOrDefault("SPRING_SERVER_URL", "http://localhost:8080");

    public static String extractBase64ImageType(@NonNull String image) {
        if (isBase64Image(image)) {
            int colonIndex = image.indexOf(":");
            int semicolonIndex = image.indexOf(";");
            return image.substring(colonIndex + 1, semicolonIndex);
        }
        throw new IllegalArgumentException("invalid string format");
    }

    public static String extractBase64ImageBytes(@NonNull String image) {
        if (isBase64Image(image)) {
            int index = image.indexOf(",");
            return image.substring(index + 1);
        }
        throw new IllegalArgumentException("invalid string format");
    }

    public static boolean isBase64Image(String value) {
        return BASE64_IMAGE_PATTERN.matcher(value).matches();
    }

    public static String getUrlToImage(@NonNull Image image) {
        if (image.getId() == null) {
            return null;
        }
        return url + "/image/" + image.getId();
    }
}
