package com.sqc.academy.library.services.Book;

import com.sqc.academy.library.dtos.request.BookRequest;
import com.sqc.academy.library.dtos.request.BookSearchRequest;
import com.sqc.academy.library.dtos.response.BookResponse;
import com.sqc.academy.library.dtos.response.PageResponse;
import org.springframework.data.domain.Pageable;

public interface BookService {
    PageResponse<BookResponse> getBooks(BookSearchRequest searchRequest, Pageable pageable);

    BookResponse createBook(BookRequest bookRequest);

    BookResponse getBook(Long id);

    BookResponse updateBook(Long id, BookRequest bookRequest);

    void deleteBook(Long id);
}
