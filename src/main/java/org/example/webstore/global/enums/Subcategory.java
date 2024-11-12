package org.example.webstore.global.enums;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Subcategory implements EnumValueProvider{
    // electronics
    AUDIO_DEVICES("audio_devices"),
    COMPUTERS_AND_LAPTOPS("computers_and_laptops"),
    PHONES_AND_ACCESSORIES("phones_and_accessories"),
    MONITORS_AND_TELEVISIONS("monitors_and_televisions"),

    // children-goods
    TOYS("toys"),
    CHILDREN_CLOTHES("children_clothes"),

    // cars
    MOTORCYCLES("motorcycles"),
    PASSENGER_CARS("passenger_cars"),
    CARGO_VEHICLES("cargo_vehicles"),

    // clothes-and-shoes
    SHOES("shoes"),
    MEN_CLOTHING("men_clothing"),
    WOMEN_CLOTHING("women_clothing"),

    // sports-and-outdoor-activities
    BICYCLES("bicycles"),
    SPORTS_EQUIPMENT("sports_equipment"),
    CAMPING_AND_HIKING("camping_and_hiking"),
    ;

    private final String subcategory;

    @Override
    public String getEnumValue() {
        return subcategory;
    }

    @SneakyThrows
    public static Subcategory fromSubcategory(@NotBlank String subcategory) {
        var value = EnumValueProvider.fromValue(subcategory, Subcategory.values());
        if (value != null) {return value;}
        throw new IllegalArgumentException("Invalid subcategory: " + subcategory);
    }

    @SneakyThrows
    public static boolean isValidSubcategory(@NotBlank String subcategory) {
        return EnumValueProvider.fromValue(subcategory, Subcategory.values()) != null;
    }
}

