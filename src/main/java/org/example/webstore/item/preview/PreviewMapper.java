package org.example.webstore.item.preview;

import org.example.webstore.image.ImageMapper;
import org.example.webstore.item.details.Item;
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

    @Mapping(target = "title", expression = "java(item.getPreview().getTitle())")
    @Mapping(target = "postingDate", expression = "java(item.getCreatedAt().toString())")
    @Mapping(target = "itemCondition", expression = "java(item.getCondition().getEnumValue())")
    @Mapping(target = "image", expression = "java(imageMapper.toGetDTO(item.getPreview().getImage()))")
    public abstract GetPreviewDTO toGetDTO(Item item);
}
