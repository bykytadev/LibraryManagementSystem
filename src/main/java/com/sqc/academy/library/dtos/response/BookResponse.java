package com.sqc.academy.library.dtos.response;

import com.sqc.academy.library.entities.enums.BookStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookResponse {
    Long bookId;
    String title;
    String author;
    String general;
    int quantity;
    int availableQuantity;
    BookStatus status;
}