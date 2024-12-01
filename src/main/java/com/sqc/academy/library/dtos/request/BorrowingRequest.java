package com.sqc.academy.library.dtos.request;

import java.sql.Timestamp;

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
    String userId;

    @NotNull(message = "Book ID is mandatory")
    Long bookId;

    @NotNull(message = "Borrow date is mandatory")
    @FutureOrPresent(message = "Borrow date must be in the present or future")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    Timestamp borrowDate;

    @NotNull(message = "Due date is mandatory")
    @FutureOrPresent(message = "Due date must be in the present or future")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    Timestamp dueDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    Timestamp returnDate;

    @NotNull(message = "Status is mandatory")
    BorrowingStatus status;
}