package org.example.webstore.item.details;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import org.example.webstore.global.validation.annotation.category.ValidCategory;
import org.example.webstore.global.validation.annotation.condition.ValidCondition;
import org.example.webstore.global.validation.annotation.image.Base64Image;
import org.example.webstore.global.validation.annotation.subcategory.ValidSubcategory;
import org.example.webstore.global.validation.groups.Post;
import org.example.webstore.item.preview.PostPreviewDTO;

public record PostItemDTO(
    @NotBlank(groups = Post.class)
    @Size(max = 256)
    String name,
    @NotBlank(groups = Post.class)
    @Size(max = 5000)
    String description,
    @Size(max = 9999999)
    @NotNull(groups = Post.class)
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
    @NotNull(groups = Post.class)
    String subcategory,
    @Size(max = 10)
    List<@Base64Image String> gallery
) {
}
