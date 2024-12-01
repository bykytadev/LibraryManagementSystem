package com.sqc.academy.library.dtos.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.sqc.academy.library.entities.enums.BorrowingStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BorrowingResponse {
    Long borrowingId;
    String userId;
    Long bookId;
    LocalDate borrowDate;
    LocalDate dueDate;
    LocalDate returnDate;
    BorrowingStatus status;

    @JsonGetter("returnDate")
    public String getReturnDate() {
        return returnDate == null ? "Not Returned" : returnDate.toString();
    }
}