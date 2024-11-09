package org.example.webstore.item.details;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.webstore.image.Image;
import org.example.webstore.item.preview.Preview;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Immutable;

@Entity(name = "item")
@Table(name = "item", schema = "public")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 256)
    @NotBlank
    private String name;

    @NotBlank
    @Size(max = 5000)
    @Column(columnDefinition = "TEXT")
    private String description;

    @Size(min = 1)
    private Integer price;

    @Valid
    private Preview preview;

    @Immutable
    @CreationTimestamp
    Instant createdAt;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinTable(schema = "public", name = "item_gallery")
    List<Image> gallery = new ArrayList<>();
}

