package org.example.webstore.global.enums;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Condition implements EnumValueProvider {
    NEW("new"),
    USED("used"),
    ;

    public final String condition;

    @Override
    public String getEnumValue() {
        return condition;
    }

    @SneakyThrows
    public static boolean isValidCondition(@NotBlank String condition) {
        return EnumValueProvider.fromValue(condition, Condition.values()) != null;
    }

    @SneakyThrows
    public static Condition fromCondition(@NotBlank String condition) {
        var value = EnumValueProvider.fromValue(condition, Condition.values());
        if (value != null) {return value;}
        throw new IllegalArgumentException("Invalid condition: " + condition);
    }
}
