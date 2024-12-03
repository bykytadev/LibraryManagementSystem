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

    // BOOKS
    BOOK_NOT_FOUND(2001, "BOOK_NOT_FOUND", HttpStatus.NOT_FOUND),
    BOOK_UNAVAILABLE(2002, "BOOK_UNAVAILABLE", HttpStatus.BAD_REQUEST),
    BOOK_ALREADY_RETURNED(2003, "BOOK_ALREADY_RETURNED", HttpStatus.BAD_REQUEST),
    BOOK_QUANTITY_INSUFFICIENT(2004, "BOOK_QUANTITY_INSUFFICIENT", HttpStatus.BAD_REQUEST),

    // CATEGORIES
    CATEGORY_NOT_FOUND(3001, "CATEGORY_NOT_FOUND", HttpStatus.NOT_FOUND),

    // USERS
    USER_NOT_FOUND(4001, "USER_NOT_FOUND", HttpStatus.NOT_FOUND),

    // BORROW RECORDS
    BORROW_RECORD_NOT_FOUND(5001, "BORROW_RECORD_NOT_FOUND", HttpStatus.NOT_FOUND);

    int code;
    String messageKey;
    HttpStatus statusCode;

    public String getMessage(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
        return bundle.getString(messageKey);
    }
}