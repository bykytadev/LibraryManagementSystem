package com.sqc.academy.library.services.book;

import com.sqc.academy.library.dtos.request.BookRequestDTO;
import com.sqc.academy.library.dtos.response.BookResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookResponseDTO create(BookRequestDTO request);

    BookResponseDTO getById(Integer id);

    Page<BookResponseDTO> getAll(Pageable pageable);

    BookResponseDTO update(Integer id, BookRequestDTO request);

    void delete(Integer id);
}