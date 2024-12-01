package com.sqc.academy.library.mappers;

import com.sqc.academy.library.dtos.request.BorrowingRequest;
import com.sqc.academy.library.dtos.response.BorrowingResponse;
import com.sqc.academy.library.entities.Borrowing;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface BorrowingMapper {

    @Mappings({
            @Mapping(target = "user.userId", source = "userId"),
            @Mapping(target = "book.bookId", source = "bookId")
    })
    Borrowing toEntity(BorrowingRequest borrowingRequest);

    @Mappings({
            @Mapping(target = "userId", source = "user.userId"),
            @Mapping(target = "bookId", source = "book.bookId")
    })
    BorrowingResponse toResponse(Borrowing borrowing);
}