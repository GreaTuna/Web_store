package org.example.webstore.item.details;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import org.example.webstore.global.validation.annotation.category.ValidCategory;
import org.example.webstore.global.validation.annotation.condition.ValidCondition;
import org.example.webstore.global.validation.annotation.image.Base64Image;
import org.example.webstore.global.validation.annotation.subcategory.ValidSubcategory;
import org.example.webstore.global.validation.groups.Post;
import org.example.webstore.item.preview.PostPreviewDTO;

public record PostItemDTO(
    @NotBlank(groups = Post.class)
    @Size(max = 5000)
    String description,
    @NotNull(groups = Post.class)
    @Min(0)
    @Max(9999999)
    Integer price,
    @Valid
    @NotNull(groups = Post.class)
    PostPreviewDTO preview,
    @ValidCondition
    @NotNull(groups = Post.class)
    String condition,
    @ValidCategory
    @NotNull(groups = Post.class)
    String category,
    @ValidSubcategory
    String subcategory,
    @Size(max = 10)
    List<@Base64Image String> gallery
) {
}
