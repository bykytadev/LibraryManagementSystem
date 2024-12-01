package com.sqc.academy.library.mappers;

import com.sqc.academy.library.dtos.request.UserRequest;
import com.sqc.academy.library.dtos.response.UserResponse;
import com.sqc.academy.library.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRequest userRequest);

    UserResponse toResponse(User user);
}
