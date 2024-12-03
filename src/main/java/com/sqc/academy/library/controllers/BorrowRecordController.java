package com.sqc.academy.library.controllers;

import java.util.List;

import com.sqc.academy.library.dtos.request.BorrowRecordRequestDTO;
import com.sqc.academy.library.dtos.request.BorrowRecordSearchRequestDTO;
import com.sqc.academy.library.dtos.response.ApiResponse;
import com.sqc.academy.library.dtos.response.BorrowRecordResponseDTO;
import com.sqc.academy.library.dtos.response.JsonResponse;
import com.sqc.academy.library.dtos.response.PageResponse;
import com.sqc.academy.library.services.borrowrecord.BorrowRecordService;
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
@RequestMapping("/borrow-records")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class BorrowRecordController {

    BorrowRecordService borrowRecordService;

    @PostMapping
    public ResponseEntity<ApiResponse<BorrowRecordResponseDTO>> create(
            @Valid @RequestBody BorrowRecordRequestDTO request) {
        BorrowRecordResponseDTO response = borrowRecordService.create(request);
        return JsonResponse.created(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BorrowRecordResponseDTO>> getById(@PathVariable("id") Integer id) {
        BorrowRecordResponseDTO response = borrowRecordService.getById(id);
        return JsonResponse.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<BorrowRecordResponseDTO>>> getAll(Pageable pageable) {
        Page<BorrowRecordResponseDTO> page = borrowRecordService.getAll(pageable);
        PageResponse<BorrowRecordResponseDTO> response = PageResponse.from(page);
        return JsonResponse.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<BorrowRecordResponseDTO>>> search(
            @Valid @RequestBody BorrowRecordSearchRequestDTO searchRequest) {
        List<BorrowRecordResponseDTO> results = borrowRecordService.search(searchRequest);
        return JsonResponse.ok(results);
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<ApiResponse<BorrowRecordResponseDTO>> returnBook(@PathVariable("id") Integer id) {
        BorrowRecordResponseDTO response = borrowRecordService.returnBook(id);
        return JsonResponse.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        borrowRecordService.delete(id);
        return JsonResponse.noContent();
    }
}