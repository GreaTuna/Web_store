package org.example.webstore.image;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.util.Base64;
import lombok.*;

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

    public Image(@NonNull String image) {
        var asBytes = image.substring(image.indexOf(",") + 1);
        this.asBytes = Base64.getDecoder().decode(asBytes);
    }
}
