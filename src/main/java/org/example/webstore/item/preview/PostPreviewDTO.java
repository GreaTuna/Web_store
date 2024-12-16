package org.example.webstore.item.preview;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.example.webstore.global.validation.annotation.image.Base64Image;
import org.example.webstore.global.validation.groups.Post;

public record PostPreviewDTO(
    @Size(max = 255)
    @NotBlank(groups = Post.class)
    String title,
    @Base64Image
    @NotBlank(groups = Post.class)
    String image
) {
}
