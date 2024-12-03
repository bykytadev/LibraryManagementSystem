package com.sqc.academy.library.dtos.request;

import com.sqc.academy.library.entities.enums.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDTO {

    String name;
    String email;
    Role role;
}
