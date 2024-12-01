package com.sqc.academy.library.mappers;

import com.sqc.academy.library.dtos.request.UserRequest;
import com.sqc.academy.library.dtos.response.UserResponse;
import com.sqc.academy.library.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({
            @Mapping(target = "userId", ignore = true),
            @Mapping(target = "createdDate", ignore = true),
            @Mapping(target = "modifiedDate", ignore = true),
            @Mapping(target = "inActive", ignore = true),
            @Mapping(target = "delete", ignore = true)
    })
    User toEntity(UserRequest userRequest);

    UserResponse toResponse(User user);
}