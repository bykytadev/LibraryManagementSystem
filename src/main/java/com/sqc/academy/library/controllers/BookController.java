package com.sqc.academy.library.controllers;

import java.util.Locale;

import com.sqc.academy.library.dtos.request.BookRequest;
import com.sqc.academy.library.dtos.request.BookSearchRequest;
import com.sqc.academy.library.dtos.response.ApiResponse;
import com.sqc.academy.library.dtos.response.BookResponse;
import com.sqc.academy.library.dtos.response.JsonResponse;
import com.sqc.academy.library.dtos.response.PageResponse;
import com.sqc.academy.library.services.Book.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class BookController {

    BookService bookService;

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<BookResponse>>> getBooks(
            @RequestParam(required = false) Long bookId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String general,
            @RequestParam(required = false) Integer quantityFrom,
            @RequestParam(required = false) Integer quantityTo,
            @RequestParam(required = false) Integer availableQuantityFrom,
            @RequestParam(required = false) Integer availableQuantityTo,
            @PageableDefault(page = 0, size = 5) Pageable pageable) {

        BookSearchRequest searchRequest = BookSearchRequest.builder()
                .bookId(bookId)
                .title(title)
                .author(author)
                .general(general)
                .quantityFrom(quantityFrom)
                .quantityTo(quantityTo)
                .availableQuantityFrom(availableQuantityFrom)
                .availableQuantityTo(availableQuantityTo)
                .build();

        PageResponse<BookResponse> books = bookService.getBooks(searchRequest, pageable);
        return JsonResponse.ok(books);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<BookResponse>> createBook(
            @Valid @RequestBody BookRequest request,
            @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        BookResponse book = bookService.createBook(request);
        return JsonResponse.created(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BookResponse>> getBook(
            @PathVariable Long id,
            @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        BookResponse book = bookService.getBook(id);
        return JsonResponse.ok(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<BookResponse>> updateBook(
            @PathVariable Long id,
            @Valid @RequestBody BookRequest request,
            @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        BookResponse book = bookService.updateBook(id, request);
        return JsonResponse.ok(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(
            @PathVariable Long id,
            @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        bookService.deleteBook(id);
        return JsonResponse.noContent();
    }
}