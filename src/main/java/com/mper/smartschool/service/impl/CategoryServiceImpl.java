package com.mper.smartschool.service.impl;

import com.mper.smartschool.dto.CategoryDto;
import com.mper.smartschool.dto.mapper.CategoryMapper;
import com.mper.smartschool.entity.Category;
import com.mper.smartschool.entity.modelsEnum.SexStatus;
import com.mper.smartschool.exception.NotFoundException;
import com.mper.smartschool.repository.CategoryRepo;
import com.mper.smartschool.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
    private final CategoryMapper categoryMapper;


    @Override
    public CategoryDto create(CategoryDto categoryDto) {

        Category category = categoryMapper.toEntyty(categoryDto);
        log.info("Created 2:{}",category);
        Category result = categoryRepo.save(category);
        log.info("Created 3:{}",result);
        CategoryDto resultDto = categoryMapper.toDto(result);
        log.info("Category created successfully: {}",resultDto);
        return resultDto;
    }

    @Override
    public CategoryDto update(CategoryDto userDto) {
        return null;
    }

    @Override
    public Collection<CategoryDto> findAll() {
        Collection<CategoryDto> result = categoryRepo.findAll()
                .stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
        log.info("IN findAll - {} delyvery found", result.size());
        return result;
    }

    @Override
    public CategoryDto findById(Long id) {

        CategoryDto result = categoryMapper.toDto(categoryRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("CategoryNotFoundException.byId", id)));
        log.info("IN findById - category: {} found by id: {}", result, id);
        return result;

    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        categoryRepo.deleteById(id);
        log.info("IN deleteById - category with id: {} successfully deleted", id);
    }

    @Override
    public CategoryDto findByName(String name) {
        CategoryDto result = categoryMapper.toDto(categoryRepo.findByName(name)
                .orElseThrow(() -> new NotFoundException("UserNotFoundException.byName", name)));
        log.info("IN findByName - user: {} found by name: {}", result, name);
        return result;
    }

    @Override
    public Collection<CategoryDto> findBySex(SexStatus sex) {
        Collection<CategoryDto> result = categoryRepo.findAllBySex(sex)
                .stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
        log.info("IN findAll - {} delyvery found", result.size());
        return result;
    }
}
