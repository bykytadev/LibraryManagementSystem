package com.sqc.academy.library.mappers;

import com.sqc.academy.library.dtos.request.BorrowRecordRequestDTO;
import com.sqc.academy.library.dtos.response.BorrowRecordResponseDTO;
import com.sqc.academy.library.entities.BorrowRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, BookMapper.class})
public interface BorrowRecordMapper {

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "book", ignore = true)
    BorrowRecord toEntity(BorrowRecordRequestDTO borrowRequest);

    BorrowRecordResponseDTO toResponseDTO(BorrowRecord borrowRecord);
}