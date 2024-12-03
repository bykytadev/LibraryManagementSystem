package com.sqc.academy.library.dtos.request;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BorrowRecordRequestDTO {

    String userId;
    Integer bookId;
    LocalDate borrowDate;
}
