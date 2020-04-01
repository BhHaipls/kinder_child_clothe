package com.mper.smartschool.service.impl;

import com.mper.smartschool.dto.ItemDto;
import com.mper.smartschool.dto.mapper.ItemMapper;
import com.mper.smartschool.entity.Item;
import com.mper.smartschool.exception.NotFoundException;
import com.mper.smartschool.repository.ItemRepo;
import com.mper.smartschool.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

    @Service
    @Slf4j
    @RequiredArgsConstructor
    public class ItemServiceImpl implements ItemService {

        private final ItemRepo itemRepo;
        private final ItemMapper itemMapper;


        @Override
        public ItemDto create(ItemDto itemDto) {
            Item item = itemMapper.toEntyty(itemDto);
            Item result = itemRepo.save(item);
            ItemDto resultDto = itemMapper.toDto(result);
            log.info("Item created successfully: {}",resultDto);
            return resultDto;
        }

        @Override
        public ItemDto update(ItemDto userDto) {
            return null;
        }

        @Override
        public Collection<ItemDto> findAll() {
            Collection<ItemDto> result = itemRepo.findAll()
                    .stream()
                    .map(itemMapper::toDto)
                    .collect(Collectors.toList());
            log.info("IN findAll - {} delyvery found", result.size());
            return result;
        }

        @Override
        public ItemDto findById(Long id) {

            ItemDto result = itemMapper.toDto(itemRepo.findById(id)
                    .orElseThrow(() -> new NotFoundException("ItemNotFoundException.byId", id)));
            log.info("IN findById - item: {} found by id: {}", result, id);
            return result;

        }

        @Override
        public void deleteById(Long id) {
            findById(id);
            itemRepo.deleteById(id);
            log.info("IN deleteById - item with id: {} successfully deleted", id);
        }

        @Override
        public ItemDto findByName(String name) {
            ItemDto result = itemMapper.toDto(itemRepo.findByName(name)
                    .orElseThrow(() -> new NotFoundException("UserNotFoundException.byName", name)));
            log.info("IN findByName - user: {} found by name: {}", result, name);
            return result;
        }

    }
