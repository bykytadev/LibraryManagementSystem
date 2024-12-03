package com.sqc.academy.library.services.category;

import java.util.Locale;

import com.sqc.academy.library.dtos.request.CategoryRequestDTO;
import com.sqc.academy.library.dtos.response.CategoryResponseDTO;
import com.sqc.academy.library.entities.Category;
import com.sqc.academy.library.exceptions.AppException;
import com.sqc.academy.library.exceptions.ErrorCode;
import com.sqc.academy.library.mappers.CategoryMapper;
import com.sqc.academy.library.repositories.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;

    @Override
    @Transactional
    public CategoryResponseDTO create(CategoryRequestDTO request) {
        Category category = categoryMapper.toEntity(request);
        return categoryMapper.toResponseDTO(categoryRepository.save(category));
    }

    @Override
    public CategoryResponseDTO getById(Integer id) {
        Locale locale = LocaleContextHolder.getLocale();
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_FOUND, locale));
        return categoryMapper.toResponseDTO(category);
    }

    @Override
    public Page<CategoryResponseDTO> getAll(Pageable pageable) {
        return categoryRepository.findAll(pageable)
                .map(categoryMapper::toResponseDTO);
    }

    @Override
    @Transactional
    public CategoryResponseDTO update(Integer id, CategoryRequestDTO request) {
        Locale locale = LocaleContextHolder.getLocale();
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_FOUND, locale));
        category.setName(request.getName());
        return categoryMapper.toResponseDTO(categoryRepository.save(category));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Locale locale = LocaleContextHolder.getLocale();
        if (!categoryRepository.existsById(id)) {
            throw new AppException(ErrorCode.CATEGORY_NOT_FOUND, locale);
        }
        categoryRepository.deleteById(id);
    }
}