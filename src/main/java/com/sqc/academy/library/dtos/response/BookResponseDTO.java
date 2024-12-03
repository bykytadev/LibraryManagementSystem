package com.sqc.academy.library.dtos.response;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookResponseDTO {

    Integer id;
    String title;
    String author;
    Integer quantity;
    Set<CategoryResponseDTO> categories;
    LocalDateTime createdDate;
    LocalDateTime modifiedDate;
}
