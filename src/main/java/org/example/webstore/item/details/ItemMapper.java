package org.example.webstore.item.details;

import org.example.webstore.image.ImageMapper;
import org.example.webstore.item.preview.GetPreviewDTO;
import org.example.webstore.item.preview.PostPreviewDTO;
import org.example.webstore.item.preview.Preview;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ItemMapper {
    @SuppressWarnings("all")
    @Autowired
    protected ImageMapper imageMapper;

    @Mapping(target = "image", expression = "java(imageMapper.toEntity(dto.image()))")
    public abstract Preview toPreviewEntity(PostPreviewDTO dto);

    @Mapping(target = "title", expression = "java(item.getPreview().getTitle())")
    @Mapping(target = "postingDate", expression = "java(item.getCreatedAt().toString())")
    @Mapping(target = "itemCondition", expression = "java(item.getCondition().getEnumValue())")
    @Mapping(target = "image", expression = "java(imageMapper.toGetDTO(item.getPreview().getImage()))")
    public abstract GetPreviewDTO toGetPreviewDTO(Item item);

    @Mapping(target = "gallery", ignore = true)
    @Mapping(target = "condition", expression = "java(Condition.fromCondition(dto.condition()))")
    @Mapping(target = "category", expression = "java(Category.fromCategory(dto.category()))")
    @Mapping(target = "subcategory", expression = "java(Subcategory.fromSubcategory(dto.subcategory()))")
    @Mapping(target = "preview", expression = "java(toPreviewEntity(dto.preview()))")
    public abstract Item toEntity(PostItemDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "gallery", ignore = true)
    public abstract Item toEntity(PostItemDTO dto, @MappingTarget Item item);

    @AfterMapping
    protected void mapGallery(PostItemDTO dto, @MappingTarget Item item) {
        if (dto.gallery() != null) {
            item.setGallery(dto.gallery().stream().map(imageMapper::toEntity).toList());
        }
    }
}
