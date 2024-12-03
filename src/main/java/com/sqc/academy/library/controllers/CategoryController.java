package com.sqc.academy.library.controllers;

import com.sqc.academy.library.dtos.request.CategoryRequestDTO;
import com.sqc.academy.library.dtos.response.ApiResponse;
import com.sqc.academy.library.dtos.response.CategoryResponseDTO;
import com.sqc.academy.library.dtos.response.JsonResponse;
import com.sqc.academy.library.dtos.response.PageResponse;
import com.sqc.academy.library.services.category.CategoryService;
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
@RequestMapping("/categories")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CategoryController {

    CategoryService categoryService;

    @PostMapping
    public ResponseEntity<ApiResponse<CategoryResponseDTO>> create(
            @Valid @RequestBody CategoryRequestDTO request) {
        CategoryResponseDTO response = categoryService.create(request);
        return JsonResponse.created(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryResponseDTO>> getById(
            @PathVariable(name = "id") Integer id) {
        CategoryResponseDTO response = categoryService.getById(id);
        return JsonResponse.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<CategoryResponseDTO>>> getAll(
            Pageable pageable) {
        Page<CategoryResponseDTO> page = categoryService.getAll(pageable);
        PageResponse<CategoryResponseDTO> response = PageResponse.from(page);
        return JsonResponse.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryResponseDTO>> update(
            @PathVariable(name = "id") Integer id,
            @Valid @RequestBody CategoryRequestDTO request) {
        CategoryResponseDTO response = categoryService.update(id, request);
        return JsonResponse.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable(name = "id") Integer id) {
        categoryService.delete(id);
        return JsonResponse.noContent();
    }
}