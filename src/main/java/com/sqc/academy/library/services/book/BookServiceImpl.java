package com.sqc.academy.library.services.book;

import java.util.HashSet;
import java.util.Set;

import com.sqc.academy.library.dtos.request.BookRequestDTO;
import com.sqc.academy.library.dtos.response.BookResponseDTO;
import com.sqc.academy.library.entities.Book;
import com.sqc.academy.library.entities.Category;
import com.sqc.academy.library.exceptions.AppException;
import com.sqc.academy.library.exceptions.ErrorCode;
import com.sqc.academy.library.mappers.BookMapper;
import com.sqc.academy.library.repositories.BookRepository;
import com.sqc.academy.library.repositories.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;
    CategoryRepository categoryRepository;
    BookMapper bookMapper;

    @Override
    @Transactional
    public BookResponseDTO create(BookRequestDTO request) {
        Book book = bookMapper.toEntity(request);
        handleCategories(book, request);
        return bookMapper.toResponseDTO(bookRepository.save(book));
    }

    @Override
    @Transactional
    public BookResponseDTO getById(Integer id) {
        return bookMapper.toResponseDTO(bookRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.BOOK_NOT_FOUND)));
    }

    @Override
    @Transactional
    public Page<BookResponseDTO> getAll(Pageable pageable) {
        return bookRepository.findAll(pageable).map(bookMapper::toResponseDTO);
    }

    @Override
    @Transactional
    public BookResponseDTO update(Integer id, BookRequestDTO request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.BOOK_NOT_FOUND));
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setQuantity(request.getQuantity());
        handleCategories(book, request);
        return bookMapper.toResponseDTO(bookRepository.save(book));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        if (!bookRepository.existsById(id)) {
            throw new AppException(ErrorCode.BOOK_NOT_FOUND);
        }
        bookRepository.deleteById(id);
    }

    private void handleCategories(Book book, BookRequestDTO request) {
        if (request.getCategoryIds() != null && !request.getCategoryIds().isEmpty()) {
            Set<Category> categories = new HashSet<>(
                    categoryRepository.findAllById(request.getCategoryIds()));
            if (categories.size() != request.getCategoryIds().size()) {
                throw new AppException(ErrorCode.CATEGORY_NOT_FOUND);
            }
            book.setCategories(categories);
        }
    }
}