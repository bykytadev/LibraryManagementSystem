package com.sqc.academy.library.dtos.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookSearchRequest {
    Long bookId;
    String title;
    String author;
    String general;
    Integer quantityFrom;
    Integer quantityTo;
    Integer availableQuantityFrom;
    Integer availableQuantityTo;
}