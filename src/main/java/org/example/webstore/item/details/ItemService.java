package org.example.webstore.item.details;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public Item findById(Long id) {
        return itemRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public void delete(Long id) {
        if (!itemRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }
        itemRepository.deleteById(id);
    }
}
