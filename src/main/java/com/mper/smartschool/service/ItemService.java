package com.mper.smartschool.service;

import com.mper.smartschool.dto.ItemDto;

import java.util.Collection;

public interface ItemService {
    ItemDto create(ItemDto categoryDto);

    ItemDto update(ItemDto categoryDto);

    Collection<ItemDto> findAll();

    ItemDto findById(Long id);

    void deleteById(Long id);

    ItemDto findByName(String name);
}
