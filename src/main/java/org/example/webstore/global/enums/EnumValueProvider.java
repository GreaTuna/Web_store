package org.example.webstore.global.enums;

import jakarta.validation.constraints.NotBlank;

public interface EnumValueProvider {
    String getEnumValue();

    static <T extends Enum<T> & EnumValueProvider> T fromValue(
        @NotBlank String value, T[] enumValues) {
        for (T enumValue : enumValues) {
            if (enumValue.getEnumValue().equals(value)) {
                return enumValue;
            }
        }
        return null;
    }
}
