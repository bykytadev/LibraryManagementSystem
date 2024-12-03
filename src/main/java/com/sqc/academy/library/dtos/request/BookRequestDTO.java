package com.sqc.academy.library.dtos.request;

import java.util.Set;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookRequestDTO {

    String title;
    String author;
    Integer quantity;
    Set<Integer> categoryIds;
}
