package org.example.webstore.image;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ImageMapper {

    public Image toEntity(String image) {
        return new Image(image);
    }
}
