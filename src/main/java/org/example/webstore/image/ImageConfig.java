package org.example.webstore.image;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ImageConfig {
    @Value("${app.image.max-size-mb}")
    private int maxSize;

    public int getMaxSizeInBytes() {
        return maxSize * 1024 * 1024;
    }
}
