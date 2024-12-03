package com.sqc.academy.library.dtos.request;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class BookRequestDTO {

    @NotBlank(message = "Title is required")
    @JsonProperty("title")
    String title;

    @JsonProperty("author")
    String author;

    @NotNull(message = "Quantity is required")
    @Min(value = 0, message = "Quantity must be greater than or equal to 0")
    @JsonProperty("quantity")
    Integer quantity;

    @JsonProperty("categoryIds")
    Set<Integer> categoryIds;
}