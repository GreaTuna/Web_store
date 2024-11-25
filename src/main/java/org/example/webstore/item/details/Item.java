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
    @Size(max = 256)
    private String name;

    @NotNull
    @NonNull
    @Size(max = 5000)
    private String description;

    @Min(0)
    @Max(9999999)
    @Setter(AccessLevel.NONE)
    private int price;

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
        this.validateSubcategoryForCategory(category, this.subcategory);
        this.category = category;
    }

    public void setSubcategory(@NonNull Subcategory subcategory) {
        this.validateSubcategoryForCategory(this.category, subcategory);
        this.subcategory = subcategory;
    }

    public void setPrice(int price) {
        this.validatePrice(price);
        this.price = price;
    }

    private void validateSubcategoryForCategory(@NonNull Category category, @NonNull Subcategory subcategory) {
        if (!CategoryMap.isCompatible(category, subcategory)) {
            throw new IllegalArgumentException("Category " + category.getEnumValue() + " is not compatible with subcategory " + subcategory.getEnumValue());
        }
    }

    private void validatePrice(int price) {
        if (price < 0 || price > 9999999) {
            throw new IllegalArgumentException("Price must be between 0 and 9999999");
        }
        if (price > 0 && this.category == Category.FREEBIES) {
            throw new IllegalArgumentException("Price for category " + this.category.getEnumValue() + " should be 0");
        }
        if (price == 0 && this.category != Category.FREEBIES) {
            throw new IllegalArgumentException("Price for category " + this.category.getEnumValue() + " should be at least 1");
        }
    }
}

