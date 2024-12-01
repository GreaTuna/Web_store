package org.example.webstore.item.details;

import jakarta.validation.groups.Default;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.webstore.global.validation.groups.Post;
import org.example.webstore.item.preview.GetPreviewDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {
    private final ItemMapper itemMapper;
    private final ItemService itemService;
    private final ItemRepository itemRepository;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody @Validated({Default.class, Post.class}) PostItemDTO itemDTO) {
        itemService.save(itemMapper.toEntity(itemDTO));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/previews")
    public ResponseEntity<List<GetPreviewDTO>> getPreviews() {
        return ResponseEntity.ok(
            itemRepository.findAll().stream().map(itemMapper::toGetPreviewDTO).toList()
        );
    }
}
