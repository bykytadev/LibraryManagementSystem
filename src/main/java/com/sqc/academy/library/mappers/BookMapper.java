package com.sqc.academy.library.mappers;

import com.sqc.academy.library.dtos.request.BookRequestDTO;
import com.sqc.academy.library.dtos.response.BookResponseDTO;
import com.sqc.academy.library.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface BookMapper {

    @Mapping(target = "categories", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "modifiedDate", ignore = true)
    Book toEntity(BookRequestDTO bookRequest);

    BookResponseDTO toResponseDTO(Book book);
}