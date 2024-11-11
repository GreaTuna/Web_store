package org.example.webstore.image;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.webstore.global.validation.annotation.Image.Base64Image;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;
    private final ImageMapper imageMapper;

    @NoArgsConstructor
    public static class PostImageDTO {
        @Base64Image
        public String image;
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        var image = imageService.findById(id);
        return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(image.getImageTypeValue()))
            .body(image.getAsBytes());
    }

    @PostMapping
    public ResponseEntity<Image> add(@RequestBody @Validated PostImageDTO dto) {
        return ResponseEntity.ok(imageService.save(imageMapper.toEntity(dto.image)));
    }
}
