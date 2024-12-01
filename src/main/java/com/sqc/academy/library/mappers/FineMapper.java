package com.sqc.academy.library.mappers;

import com.sqc.academy.library.dtos.request.FineRequest;
import com.sqc.academy.library.dtos.response.FineResponse;
import com.sqc.academy.library.entities.Fine;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FineMapper {
    Fine toEntity(FineRequest fineRequest);

    FineResponse toResponse(Fine fine);
}
