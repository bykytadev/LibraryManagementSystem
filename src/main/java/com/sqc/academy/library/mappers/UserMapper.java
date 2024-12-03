package com.sqc.academy.library.mappers;

import com.sqc.academy.library.dtos.request.UserRequestDTO;
import com.sqc.academy.library.dtos.response.UserResponseDTO;
import com.sqc.academy.library.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "modifiedDate", ignore = true)
    User toEntity(UserRequestDTO userRequest);

    UserResponseDTO toResponseDTO(User user);
}