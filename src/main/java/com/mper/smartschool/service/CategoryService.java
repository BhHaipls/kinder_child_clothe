package com.mper.smartschool.service;

import com.mper.smartschool.dto.CategoryDto;
import com.mper.smartschool.entity.modelsEnum.SexStatus;

import java.util.Collection;

public interface CategoryService {
    CategoryDto create(CategoryDto categoryDto);

    CategoryDto update(CategoryDto categoryDto);

    Collection<CategoryDto> findAll();

    CategoryDto findById(Long id);

    void deleteById(Long id);

    CategoryDto findByName(String name);
    Collection<CategoryDto> findBySex(SexStatus sex);
}
