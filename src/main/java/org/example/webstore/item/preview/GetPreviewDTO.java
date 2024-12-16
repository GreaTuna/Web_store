package org.example.webstore.item.preview;

public record GetPreviewDTO(
    Long id,
    String title,
    String image,
    Integer price,
    String postingDate,
    String itemCondition
) {
}
