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
    byte @NonNull [] asBytes;

    public Image(@NonNull String image) {
        String encodedString = Base64.getEncoder().encodeToString(image.getBytes());
        this.asBytes = Base64.getDecoder().decode(encodedString);
    }
}
