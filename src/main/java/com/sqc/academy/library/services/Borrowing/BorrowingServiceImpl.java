package com.sqc.academy.library.services.Borrowing;

import java.util.Locale;

import com.sqc.academy.library.dtos.request.BorrowingRequest;
import com.sqc.academy.library.dtos.response.BorrowingResponse;
import com.sqc.academy.library.entities.Book;
import com.sqc.academy.library.entities.Borrowing;
import com.sqc.academy.library.entities.enums.BorrowingStatus;
import com.sqc.academy.library.exceptions.AppException;
import com.sqc.academy.library.exceptions.ErrorCode;
import com.sqc.academy.library.mappers.BorrowingMapper;
import com.sqc.academy.library.repositories.BookRepository;
import com.sqc.academy.library.repositories.BorrowingRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class BorrowingServiceImpl implements BorrowingService {

    BookRepository bookRepository;
    BorrowingRepository borrowingRepository;
    BorrowingMapper borrowingMapper;

    @Override
    @Transactional
    public BorrowingResponse borrowBook(BorrowingRequest request) {
        // 1. Find and validate book
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new AppException(ErrorCode.BOOK_NOT_FOUND, Locale.getDefault()));

        // 2. Check book availability
        if (book.getAvailableQuantity() <= 0) {
            throw new AppException(ErrorCode.BOOK_ALREADY_BORROWED, Locale.getDefault());
        }

        // 3. Create borrowing record
        Borrowing borrowing = borrowingMapper.toEntity(request);
        borrowing.setStatus(BorrowingStatus.BORROWED);
        borrowing.setReturnDate(null); // Set returnDate to null by default

        // 4. Update book quantity
        book.setAvailableQuantity(book.getAvailableQuantity() - 1);
        bookRepository.save(book);

        // 5. Save borrowing record
        borrowing = borrowingRepository.save(borrowing);

        // 6. Return response
        return borrowingMapper.toResponse(borrowing);
    }
}