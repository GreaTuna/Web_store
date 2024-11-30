package org.example.webstore.item.details;

import org.example.webstore.image.ImageMapper;
import org.example.webstore.item.preview.PreviewMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ItemMapper {
    @SuppressWarnings("all")
    @Autowired
    protected ImageMapper imageMapper;

    @SuppressWarnings("all")
    @Autowired
    protected PreviewMapper previewMapper;

    @Mapping(target = "condition", expression = "java(Condition.fromCondition(dto.condition()))")
    @Mapping(target = "category", expression = "java(Category.fromCategory(dto.category()))")
    @Mapping(target = "subcategory", expression = "java(Subcategory.fromSubcategory(dto.subcategory()))")
    @Mapping(target = "preview", expression = "java(previewMapper.toEntity(dto.preview()))")
    @Mapping(target = "gallery", expression = "java(dto.gallery().stream().map(imageMapper::toEntity).toList())")
    public abstract Item toEntity(PostItemDTO dto);
}
