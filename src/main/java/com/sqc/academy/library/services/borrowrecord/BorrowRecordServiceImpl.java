package com.sqc.academy.library.services.borrowrecord;

import java.time.LocalDate;
import java.util.List;

import com.sqc.academy.library.dtos.request.BorrowRecordRequestDTO;
import com.sqc.academy.library.dtos.request.BorrowRecordSearchRequestDTO;
import com.sqc.academy.library.dtos.response.BorrowRecordResponseDTO;
import com.sqc.academy.library.exceptions.AppException;
import com.sqc.academy.library.exceptions.ErrorCode;
import com.sqc.academy.library.mappers.BorrowRecordMapper;
import com.sqc.academy.library.repositories.BookRepository;
import com.sqc.academy.library.repositories.BorrowRecordRepository;
import com.sqc.academy.library.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class BorrowRecordServiceImpl implements BorrowRecordService {

    BorrowRecordRepository borrowRecordRepository;
    BorrowRecordMapper borrowRecordMapper;
    BookRepository bookRepository;
    UserRepository userRepository;

    @Override
    @Transactional
    public BorrowRecordResponseDTO create(BorrowRecordRequestDTO request) {
        var user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        var book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new AppException(ErrorCode.BOOK_NOT_FOUND));

        if (book.getQuantity() <= 0) {
            throw new AppException(ErrorCode.BOOK_UNAVAILABLE);
        }

        var borrowRecord = borrowRecordMapper.toEntity(request);
        borrowRecord.setUser(user);
        borrowRecord.setBook(book);
        borrowRecord.setBorrowDate(LocalDate.now());

        book.decrementQuantity();
        borrowRecordRepository.save(borrowRecord);
        return borrowRecordMapper.toResponseDTO(borrowRecord);
    }

    @Override
    public BorrowRecordResponseDTO getById(Integer id) {
        return borrowRecordRepository.findById(id)
                .map(borrowRecordMapper::toResponseDTO)
                .orElseThrow(() -> new AppException(ErrorCode.BORROW_RECORD_NOT_FOUND));
    }

    @Override
    public Page<BorrowRecordResponseDTO> getAll(Pageable pageable) {
        return borrowRecordRepository.findAll(pageable)
                .map(borrowRecordMapper::toResponseDTO);
    }

    @Override
    public List<BorrowRecordResponseDTO> search(BorrowRecordSearchRequestDTO searchRequest) {
        return borrowRecordRepository.search(
                searchRequest.getUserId(),
                searchRequest.getBookId(),
                searchRequest.getIsReturned(),
                searchRequest.getStartDate(),
                searchRequest.getEndDate())
                .stream()
                .map(borrowRecordMapper::toResponseDTO)
                .toList();
    }

    @Override
    @Transactional
    public BorrowRecordResponseDTO returnBook(Integer id) {
        var borrowRecord = borrowRecordRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.BORROW_RECORD_NOT_FOUND));

        if (borrowRecord.getReturnDate() != null) {
            throw new AppException(ErrorCode.BOOK_ALREADY_RETURNED);
        }

        borrowRecord.setReturnDate(LocalDate.now());
        borrowRecord.getBook().incrementQuantity();
        return borrowRecordMapper.toResponseDTO(borrowRecord);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        if (!borrowRecordRepository.existsById(id)) {
            throw new AppException(ErrorCode.BORROW_RECORD_NOT_FOUND);
        }
        borrowRecordRepository.deleteById(id);
    }
}