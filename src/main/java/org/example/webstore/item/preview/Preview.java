package org.example.webstore.item.preview;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    @Size(max = 256)
    @Column(nullable = false)
    private String title;

    @NotNull
    @NonNull
    @JoinColumn(name = "preview_image_id")
    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    private Image image;
}
