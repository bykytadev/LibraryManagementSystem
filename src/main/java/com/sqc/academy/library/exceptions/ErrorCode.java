package com.sqc.academy.library.exceptions;

import java.util.Locale;
import java.util.ResourceBundle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {

    BOOK_NOT_FOUND(1001, "book.not.found", HttpStatus.NOT_FOUND),
    BOOK_ALREADY_BORROWED(1002, "book.already.borrowed", HttpStatus.BAD_REQUEST);

    int code;
    String messageKey;
    HttpStatus statusCode;

    public String getMessage(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
        return bundle.getString(messageKey);
    }
}