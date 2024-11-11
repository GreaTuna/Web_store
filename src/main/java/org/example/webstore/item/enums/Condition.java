package org.example.webstore.item.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Condition {
    NEW("new"),
    USED("used"),
    ;

    public final String condition;
}
