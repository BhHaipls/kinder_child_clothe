package com.mper.smartschool.dto.mapper;

import com.mper.smartschool.dto.ItemDto;
import com.mper.smartschool.entity.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ItemMapper {
    ItemDto toDto(Item comment);

    Item toEntyty(ItemDto dto);


}

