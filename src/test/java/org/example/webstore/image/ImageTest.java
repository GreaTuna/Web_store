package org.example.webstore.image;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Base64;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class ImageTest {
    @Test
    public void testValidBase64Image() {
        var image = new Image("string");
        Assert.notNull(image, "Image is null");
    }

    @Test
    public void nullBase64Image() {
        assertThrows(NullPointerException.class, () -> new Image(null));
    }

    @Test
    public void testTooLargeBase64Image() {
        var exception = assertThrows(IllegalArgumentException.class, () -> new Image(tooLargeBase64Image()));
        assertEquals("Image too large", exception.getMessage());
    }

    private String tooLargeBase64Image() {
        int bytesToGenerate = 11 * 1024 * 1024;
        byte[] randomBytes = new byte[bytesToGenerate];
        new java.util.Random().nextBytes(randomBytes);
        return Base64.getEncoder().encodeToString(randomBytes);
    }
}
