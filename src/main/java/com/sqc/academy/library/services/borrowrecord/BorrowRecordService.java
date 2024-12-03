package com.sqc.academy.library.services.borrowrecord;

import java.util.List;

import com.sqc.academy.library.dtos.request.BorrowRecordRequestDTO;
import com.sqc.academy.library.dtos.request.BorrowRecordSearchRequestDTO;
import com.sqc.academy.library.dtos.response.BorrowRecordResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BorrowRecordService {
    BorrowRecordResponseDTO create(BorrowRecordRequestDTO request);

    BorrowRecordResponseDTO getById(Integer id);

    Page<BorrowRecordResponseDTO> getAll(Pageable pageable);

    List<BorrowRecordResponseDTO> search(BorrowRecordSearchRequestDTO searchRequest);

    BorrowRecordResponseDTO returnBook(Integer id);

    void delete(Integer id);
}