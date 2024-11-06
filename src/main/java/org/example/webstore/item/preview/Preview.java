package org.example.webstore.item.preview;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.example.webstore.image.Image;


@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Preview {
    @Size(max = 256)
    @NotBlank
    private String title;

    @NotNull
    @NonNull
    private Image image;
}
