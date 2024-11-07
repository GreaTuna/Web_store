package org.example.webstore.item.preview;

import org.example.webstore.image.ImageMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class PreviewMapper {
    @SuppressWarnings("all")
    @Autowired
    ImageMapper imageMapper;

    @Mapping(target = "image", expression = "java(imageMapper.toEntity(dto.image()))")
    public abstract Preview toEntity(PostPreviewDTO dto);

    @Mapping(target = "image", expression = "java(imageMapper.toGetDTO(preview.getImage()))")
    public abstract GetPreviewDTO toGetDTO(Preview preview);
}
