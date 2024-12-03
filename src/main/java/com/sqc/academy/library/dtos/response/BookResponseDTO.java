package com.sqc.academy.library.dtos.response;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookResponseDTO {

    @JsonProperty("id")
    Integer id;

    @JsonProperty("title")
    String title;

    @JsonProperty("author")
    String author;

    @JsonProperty("quantity")
    Integer quantity;

    @JsonProperty("categories")
    Set<CategoryResponseDTO> categories;
}
