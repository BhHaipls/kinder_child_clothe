package com.mper.smartschool.controller;

import com.mper.smartschool.dto.CategoryDto;
import com.mper.smartschool.entity.modelsEnum.SexStatus;
import com.mper.smartschool.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    CategoryDto create(CategoryDto categoryDto){
        log.info("Created :{}",categoryDto);
        return categoryService.create(categoryDto);
    }

    @GetMapping
    Collection<CategoryDto> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {

        categoryService.deleteById(id);
    }

    @GetMapping("/")
    public CategoryDto findByName(@RequestParam("category") String name) {

        return categoryService.findByName(name);
    }

    @GetMapping("/{SexStatus}")
    public Collection<CategoryDto> findBySex(@RequestParam("category") SexStatus sex) {

        return categoryService.findBySex(sex);
    }


}
