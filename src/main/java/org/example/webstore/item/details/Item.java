package org.example.webstore.item.details;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.example.webstore.image.Image;
import org.example.webstore.item.preview.Preview;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Immutable;

@Valid
@Entity(name = "item")
@Table(name = "item", schema = "public")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NonNull
    private String name;

    @NotNull
    @NonNull
    @Size(max = 5000)
    private String description;

    @Min(1)
    @Max(9999999)
    private Integer price;

    @Valid
    @NonNull
    private Preview preview;

    @Immutable
    @CreationTimestamp
    public Instant createdAt;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinTable(schema = "public", name = "item_gallery")
    private List<Image> gallery = new ArrayList<>();
}

