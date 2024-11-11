package org.example.webstore.global.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Category {
    CARS("cars"),
    FREEBIES("freebies"),
    ELECTRONICS("electronics"),
    CHILDREN_GOODS("children-goods"),
    CLOTHES_AND_SHOES("clothes-and-shoes"),
    SPORTS_AND_OUTDOOR_ACTIVITIES("sports-and-outdoor-activities"),
    ;

    private final String category;
}
