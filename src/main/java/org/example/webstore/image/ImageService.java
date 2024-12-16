package org.example.webstore.image;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    public Image findById(final Long id) {
        return imageRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Image save(final Image image) {
        return imageRepository.save(image);
    }
}
