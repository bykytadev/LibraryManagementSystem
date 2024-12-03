package com.sqc.academy.library.mappers;

import com.sqc.academy.library.dtos.request.CategoryRequestDTO;
import com.sqc.academy.library.dtos.response.CategoryResponseDTO;
import com.sqc.academy.library.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "modifiedDate", ignore = true)
    Category toEntity(CategoryRequestDTO categoryRequest);

    CategoryResponseDTO toResponseDTO(Category category);
}