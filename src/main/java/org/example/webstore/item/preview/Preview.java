package org.example.webstore.item.preview;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.example.webstore.image.Image;


@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Preview {
    @NonNull
    @NotNull
    @Size(max = 256)
    private String title;

    @JoinColumn(name = "preview_image_id")
    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    private Image image;
}
