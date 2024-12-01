package com.sqc.academy.library.exceptions;

import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class ResourceNotFoundException extends RuntimeException {
    ErrorCode errorCode;

    public ResourceNotFoundException(ErrorCode errorCode) {
        super(errorCode.getMessageKey());
        this.errorCode = errorCode;
    }
}