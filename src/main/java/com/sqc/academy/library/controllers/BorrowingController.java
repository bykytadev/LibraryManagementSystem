package com.sqc.academy.library.controllers;

import com.sqc.academy.library.dtos.request.BorrowingRequest;
import com.sqc.academy.library.dtos.response.ApiResponse;
import com.sqc.academy.library.dtos.response.BorrowingResponse;
import com.sqc.academy.library.dtos.response.JsonResponse;
import com.sqc.academy.library.services.Borrowing.BorrowingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/borrowings")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@Slf4j
public class BorrowingController {

    BorrowingService borrowingService;

    @PostMapping
    public ResponseEntity<ApiResponse<BorrowingResponse>> borrowBook(
            @Valid @RequestBody BorrowingRequest request) {

        log.info("Received borrow book request: {}", request);

        BorrowingResponse response = borrowingService.borrowBook(request);
        return JsonResponse.created(response);
    }
}
