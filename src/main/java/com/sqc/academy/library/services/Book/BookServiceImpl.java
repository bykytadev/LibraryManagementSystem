package com.sqc.academy.library.services.Book;

import com.sqc.academy.library.dtos.request.BookRequest;
import com.sqc.academy.library.dtos.request.BookSearchRequest;
import com.sqc.academy.library.dtos.response.BookResponse;
import com.sqc.academy.library.dtos.response.PageResponse;
import com.sqc.academy.library.entities.Book;
import com.sqc.academy.library.entities.enums.BookStatus;
import com.sqc.academy.library.exceptions.ErrorCode;
import com.sqc.academy.library.exceptions.ResourceNotFoundException;
import com.sqc.academy.library.mappers.BookMapper;
import com.sqc.academy.library.repositories.BookRepository;
import com.sqc.academy.library.specifications.BookSpecification;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;
    BookMapper bookMapper;

    @Override
    @Transactional(readOnly = true)
    public PageResponse<BookResponse> getBooks(BookSearchRequest searchRequest, Pageable pageable) {
        Specification<Book> spec = Specification.where(null);

        if (searchRequest.getBookId() != null) {
            spec = spec.and(BookSpecification.hasBookId(searchRequest.getBookId()));
        }
        if (searchRequest.getTitle() != null) {
            spec = spec.and(BookSpecification.hasTitle(searchRequest.getTitle()));
        }
        if (searchRequest.getAuthor() != null) {
            spec = spec.and(BookSpecification.hasAuthor(searchRequest.getAuthor()));
        }
        if (searchRequest.getGeneral() != null) {
            spec = spec.and(BookSpecification.hasGeneral(searchRequest.getGeneral()));
        }
        if (searchRequest.getQuantityFrom() != null) {
            spec = spec.and(BookSpecification.hasQuantityFrom(searchRequest.getQuantityFrom()));
        }
        if (searchRequest.getQuantityTo() != null) {
            spec = spec.and(BookSpecification.hasQuantityTo(searchRequest.getQuantityTo()));
        }
        if (searchRequest.getAvailableQuantityFrom() != null) {
            spec = spec.and(BookSpecification.hasAvailableQuantityFrom(searchRequest.getAvailableQuantityFrom()));
        }
        if (searchRequest.getAvailableQuantityTo() != null) {
            spec = spec.and(BookSpecification.hasAvailableQuantityTo(searchRequest.getAvailableQuantityTo()));
        }

        Page<Book> bookPage = bookRepository.findAll(spec, pageable);
        return PageResponse.from(bookPage.map(bookMapper::toResponse));
    }

    @Override
    @Transactional
    public BookResponse createBook(BookRequest bookRequest) {
        Book book = bookMapper.toEntity(bookRequest);

        // Set AVAILABLE as default status
        book.setStatus(BookStatus.AVAILABLE);

        if (book.getQuantity() == 0) {
            book.setStatus(BookStatus.UNAVAILABLE);
        }

        book = bookRepository.save(book);

        return bookMapper.toResponse(book);
    }

    @Override
    @Transactional(readOnly = true)
    public BookResponse getBook(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.BOOK_NOT_FOUND));
    }

    @Override
    @Transactional
    public BookResponse updateBook(Long id, BookRequest bookRequest) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.BOOK_NOT_FOUND));
        bookMapper.updateEntity(bookRequest, book);

        if (book.getQuantity() == 0) {
            book.setStatus(BookStatus.UNAVAILABLE);
        } else if (book.getAvailableQuantity() == 0) {
            book.setStatus(BookStatus.BORROWED);
        }

        book = bookRepository.save(book);

        return bookMapper.toResponse(book);
    }

    @Override
    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}