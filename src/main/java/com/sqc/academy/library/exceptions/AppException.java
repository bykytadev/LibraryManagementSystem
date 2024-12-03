package com.sqc.academy.library.exceptions;

import java.util.Locale;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class AppException extends RuntimeException {

    public AppException(ErrorCode errorCode, Locale locale) {
        super(errorCode.getMessage(locale));
        this.errorCode = errorCode;
        this.locale = locale;
    }

    public AppException(ErrorCode errorCode) {
        this(errorCode, Locale.getDefault());
    }

    ErrorCode errorCode;
    Locale locale;
}