package com.sqc.academy.library.dtos.response;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BorrowRecordResponseDTO {

    Integer id;
    LocalDate borrowDate;
    LocalDate returnDate;
    UserResponseDTO user;
    BookResponseDTO book;
}
