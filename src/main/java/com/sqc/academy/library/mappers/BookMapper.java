package com.sqc.academy.library.mappers;

import com.sqc.academy.library.dtos.request.BookRequest;
import com.sqc.academy.library.dtos.response.BookResponse;
import com.sqc.academy.library.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toEntity(BookRequest bookRequest);

    BookResponse toResponse(Book book);

    void updateEntity(BookRequest bookRequest, @MappingTarget Book book);
}