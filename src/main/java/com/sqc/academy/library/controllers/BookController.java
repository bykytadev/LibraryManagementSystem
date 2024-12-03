package com.sqc.academy.library.controllers;

import com.sqc.academy.library.dtos.request.BookRequestDTO;
import com.sqc.academy.library.dtos.response.ApiResponse;
import com.sqc.academy.library.dtos.response.BookResponseDTO;
import com.sqc.academy.library.dtos.response.JsonResponse;
import com.sqc.academy.library.dtos.response.PageResponse;
import com.sqc.academy.library.services.book.BookService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class BookController {

    BookService bookService;

    @PostMapping
    public ResponseEntity<ApiResponse<BookResponseDTO>> create(@Valid @RequestBody BookRequestDTO request) {
        BookResponseDTO response = bookService.create(request);
        return JsonResponse.created(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BookResponseDTO>> getById(@PathVariable(name = "id") Integer id) {
        BookResponseDTO response = bookService.getById(id);
        return JsonResponse.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<BookResponseDTO>>> getAll(Pageable pageable) {
        Page<BookResponseDTO> page = bookService.getAll(pageable);
        PageResponse<BookResponseDTO> response = PageResponse.from(page);
        return JsonResponse.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<BookResponseDTO>> update(@PathVariable(name = "id") Integer id,
            @Valid @RequestBody BookRequestDTO request) {
        BookResponseDTO response = bookService.update(id, request);
        return JsonResponse.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id) {
        bookService.delete(id);
        return JsonResponse.noContent();
    }
}