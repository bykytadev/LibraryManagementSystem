package com.sqc.academy.library.dtos.response;

import java.time.LocalDateTime;

import com.sqc.academy.library.entities.enums.Role;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseDTO {

    String id;
    String name;
    String email;
    Role role;
    LocalDateTime createdDate;
    LocalDateTime modifiedDate;
}