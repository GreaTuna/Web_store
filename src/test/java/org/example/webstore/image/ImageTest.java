package org.example.webstore.image;

import static org.junit.jupiter.api.Assertions.*;

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
}
