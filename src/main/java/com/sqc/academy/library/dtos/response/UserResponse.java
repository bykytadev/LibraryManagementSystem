package com.sqc.academy.library.dtos.response;

import com.sqc.academy.library.entities.enums.UserStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String userId;
    String username;
    String fullName;
    String email;
    String phone;
    UserStatus status;
}