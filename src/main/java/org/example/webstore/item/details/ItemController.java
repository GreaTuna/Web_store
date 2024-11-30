package org.example.webstore.item.details;

import jakarta.validation.groups.Default;
import lombok.RequiredArgsConstructor;
import org.example.webstore.global.validation.groups.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {
    private final ItemMapper itemMapper;
    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody @Validated({Default.class, Post.class}) PostItemDTO itemDTO) {
        itemService.save(itemMapper.toEntity(itemDTO));
        return ResponseEntity.ok().build();
    }
}
