package org.example.webstore.image;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Base64;
import lombok.*;
import org.example.webstore.global.enums.ImageType;
import org.hibernate.annotations.Immutable;

@Entity(name = "image")
@Table(name = "image", schema = "public")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private byte @NonNull [] asBytes;

    @NotNull
    @Immutable
    @Enumerated(EnumType.ORDINAL)
    private ImageType imageType;

    public Image(@NonNull String image) {
        this.imageType = ImageType.fromMimeType(ImageUtil.extractBase64ImageType(image));
        this.asBytes = Base64.getDecoder().decode(ImageUtil.extractBase64ImagBytes(image));
    }
}
