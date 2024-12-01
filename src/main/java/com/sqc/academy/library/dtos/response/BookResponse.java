package com.sqc.academy.library.dtos.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookResponse {
    Long bookId;
    String title;
    String author;
    String general;
    int quantity;
    int availableQuantity;
}