package com.sqc.academy.library.dtos.response;

import java.sql.Timestamp;

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
    Timestamp borrowDate;
    Timestamp dueDate;
    Timestamp returnDate;
    BorrowingStatus status;
}