package com.sqc.academy.library.mappers;

import com.sqc.academy.library.dtos.request.FineRequest;
import com.sqc.academy.library.dtos.response.FineResponse;
import com.sqc.academy.library.entities.Fine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface FineMapper {
    @Mappings({
            @Mapping(target = "fineId", ignore = true),
            @Mapping(target = "createdDate", ignore = true),
            @Mapping(target = "modifiedDate", ignore = true),
            @Mapping(target = "inActive", ignore = true),
            @Mapping(target = "delete", ignore = true),
            @Mapping(target = "borrowing.borrowingId", source = "borrowingId")
    })
    Fine toEntity(FineRequest fineRequest);

    @Mapping(target = "borrowingId", source = "borrowing.borrowingId")
    FineResponse toResponse(Fine fine);
}