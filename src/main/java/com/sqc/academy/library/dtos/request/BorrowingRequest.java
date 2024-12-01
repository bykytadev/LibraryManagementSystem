package com.sqc.academy.library.dtos.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sqc.academy.library.entities.enums.BorrowingStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BorrowingRequest {

    @NotNull(message = "User ID is mandatory")
    @JsonProperty("user_id")
    String userId;

    @NotNull(message = "Book ID is mandatory")
    @JsonProperty("book_id")
    Long bookId;

    @NotNull(message = "Borrow date is mandatory")
    @FutureOrPresent(message = "Borrow date must be in the present or future")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonProperty("borrow_date")
    LocalDate borrowDate;

    @NotNull(message = "Due date is mandatory")
    @FutureOrPresent(message = "Due date must be in the present or future")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonProperty("due_date")
    LocalDate dueDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonProperty("return_date")
    LocalDate returnDate;

    @NotNull(message = "Status is mandatory")
    @JsonProperty("status")
    BorrowingStatus status;
}