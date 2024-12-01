package com.sqc.academy.library.mappers;

import com.sqc.academy.library.dtos.request.BorrowingRequest;
import com.sqc.academy.library.dtos.response.BorrowingResponse;
import com.sqc.academy.library.entities.Borrowing;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BorrowingMapper {
    Borrowing toEntity(BorrowingRequest borrowingRequest);

    BorrowingResponse toResponse(Borrowing borrowing);
}
