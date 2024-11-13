package org.example.webstore.item.details;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import lombok.*;
import org.example.webstore.global.enums.Category;
import org.example.webstore.global.enums.Condition;
import org.example.webstore.global.enums.Subcategory;
import org.example.webstore.image.Image;
import org.example.webstore.item.CategoryMap;
import org.example.webstore.item.preview.Preview;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Immutable;

@Entity(name = "item")
@Table(name = "item", schema = "public")
@Getter
@Setter
@RequiredArgsConstructor
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

    @Enumerated(EnumType.ORDINAL)
    private Condition condition;

    @NotNull
    @NonNull
    @Setter(AccessLevel.NONE)
    @Enumerated(EnumType.ORDINAL)
    private Category category;

    @Setter(AccessLevel.NONE)
    @Enumerated(EnumType.ORDINAL)
    private Subcategory subcategory;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinTable(schema = "public", name = "item_gallery")
    private List<Image> gallery = new ArrayList<>();


    public void setCategory(@NonNull Category category) {
        if (!CategoryMap.isCompatible(category, this.subcategory)) {
            throw new IllegalArgumentException("Category " + category.getEnumValue() + " is not compatible with subcategory " + this.subcategory.getEnumValue());
        }
    }

    public void setSubcategory(@NonNull Subcategory subcategory) {
        if (!CategoryMap.isCompatible(this.category, subcategory)) {
            throw new IllegalArgumentException("Category " + this.category.getEnumValue() + " is not compatible with subcategory " + subcategory.getEnumValue());
        }
    }
}

