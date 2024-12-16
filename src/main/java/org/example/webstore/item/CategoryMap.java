package org.example.webstore.item;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.NonNull;
import org.example.webstore.global.enums.Category;
import org.example.webstore.global.enums.Subcategory;

public class CategoryMap {
    public static final Map<Category, List<Subcategory>> CATEGORY_MAP;

    static {
        CATEGORY_MAP = new HashMap<>();

        CATEGORY_MAP.put(Category.FREEBIES, null);
        CATEGORY_MAP.put(Category.CHILDREN_GOODS, Arrays.asList(Subcategory.TOYS, Subcategory.CHILDREN_CLOTHES));
        CATEGORY_MAP.put(Category.CARS, Arrays.asList(Subcategory.MOTORCYCLES, Subcategory.PASSENGER_CARS, Subcategory.CARGO_VEHICLES));
        CATEGORY_MAP.put(Category.CLOTHES_AND_SHOES, Arrays.asList(Subcategory.SHOES, Subcategory.MEN_CLOTHING, Subcategory.WOMEN_CLOTHING));
        CATEGORY_MAP.put(Category.SPORTS_AND_OUTDOOR_ACTIVITIES, Arrays.asList(Subcategory.BICYCLES, Subcategory.SPORTS_EQUIPMENT, Subcategory.CAMPING_AND_HIKING));
        CATEGORY_MAP.put(Category.ELECTRONICS, Arrays.asList(Subcategory.AUDIO_DEVICES, Subcategory.COMPUTERS_AND_LAPTOPS, Subcategory.PHONES_AND_ACCESSORIES, Subcategory.MONITORS_AND_TELEVISIONS));
    }

    public static boolean isCompatible(@NonNull final Category category, final Subcategory subcategory) {
        return CATEGORY_MAP.get(category).contains(subcategory);
    }
}
