package org.example.webstore.item.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Condition {
    NEW("New"),
    USED("Used"),
    ;

    public final String condition;
}
