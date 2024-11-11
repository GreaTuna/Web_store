package org.example.webstore.global.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Subcategories {
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
}
