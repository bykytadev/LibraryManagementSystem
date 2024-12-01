package com.sqc.academy.library.dtos.request;

import com.sqc.academy.library.entities.enums.UserStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {

    @NotBlank(message = "Username is mandatory")
    @Size(max = 50, message = "Username can have a maximum of 50 characters")
    String username;

    @NotBlank(message = "Full name is mandatory")
    @Size(max = 100, message = "Full name can have a maximum of 100 characters")
    String fullName;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    @Size(max = 100, message = "Email can have a maximum of 100 characters")
    String email;

    @Size(max = 15, message = "Phone can have a maximum of 15 characters")
    String phone;

    @NotNull(message = "Status is mandatory")
    UserStatus status;
}