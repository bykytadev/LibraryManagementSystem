package com.sqc.academy.library.services.category;

import com.sqc.academy.library.dtos.request.CategoryRequestDTO;
import com.sqc.academy.library.dtos.response.CategoryResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    CategoryResponseDTO create(CategoryRequestDTO request);

    CategoryResponseDTO getById(Integer id);

    Page<CategoryResponseDTO> getAll(Pageable pageable);

    CategoryResponseDTO update(Integer id, CategoryRequestDTO request);

    void delete(Integer id);
}