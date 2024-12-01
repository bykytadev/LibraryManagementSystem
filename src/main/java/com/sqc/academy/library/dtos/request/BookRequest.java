package com.sqc.academy.library.dtos.request;

import com.sqc.academy.library.entities.enums.BookStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookRequest {

    @NotBlank(message = "Title is mandatory")
    @Size(max = 200, message = "Title can have a maximum of 200 characters")
    String title;

    @NotBlank(message = "Author is mandatory")
    @Size(max = 100, message = "Author can have a maximum of 100 characters")
    String author;

    @Size(max = 50, message = "General can have a maximum of 50 characters")
    String general;

    @NotNull(message = "Quantity is mandatory")
    @Min(value = 0, message = "Quantity must be at least 0")
    int quantity;

    @NotNull(message = "Available quantity is mandatory")
    @Min(value = 0, message = "Available quantity must be at least 0")
    int availableQuantity;

    BookStatus status;
}