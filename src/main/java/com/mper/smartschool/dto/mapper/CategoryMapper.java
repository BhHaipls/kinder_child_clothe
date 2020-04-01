package com.mper.smartschool.dto.mapper;

import com.mper.smartschool.dto.CategoryDto;
import com.mper.smartschool.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface CategoryMapper {
    CategoryDto toDto(Category category);

    Category toEntyty(CategoryDto dto);
}
