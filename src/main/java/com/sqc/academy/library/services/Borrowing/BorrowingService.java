package com.sqc.academy.library.services.Borrowing;

import com.sqc.academy.library.dtos.request.BorrowingRequest;
import com.sqc.academy.library.dtos.response.BorrowingResponse;

public interface BorrowingService {
    BorrowingResponse borrowBook(BorrowingRequest borrowingRequest);
}