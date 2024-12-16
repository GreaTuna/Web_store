package org.example.webstore.global.enums;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Category implements EnumValueProvider{
    CARS("cars"),
    FREEBIES("freebies"),
    ELECTRONICS("electronics"),
    CHILDREN_GOODS("children-goods"),
    CLOTHES_AND_SHOES("clothes-and-shoes"),
    SPORTS_AND_OUTDOOR_ACTIVITIES("sports-and-outdoor-activities"),
    ;

    private final String category;

    @Override
    public String getEnumValue() {
        return category;
    }

    @SneakyThrows
    public static Category fromCategory(@NotBlank String category) {
        var value = EnumValueProvider.fromValue(category, Category.values());
        if (value != null) {return value;}
        throw new IllegalArgumentException("Invalid category: " + category);
    }

    @SneakyThrows
    public static boolean isValidCategory(@NotBlank String category) {
        return  EnumValueProvider.fromValue(category, Category.values()) != null;
    }
}
