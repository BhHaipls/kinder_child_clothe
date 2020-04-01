package com.mper.smartschool.controller;

import com.mper.smartschool.dto.ItemDto;
import com.mper.smartschool.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {
    private final ItemService itemService;
    @PostMapping
    ItemDto create(ItemDto itemDto){
        return itemService.create(itemDto);
    }

    @GetMapping
    Collection<ItemDto> findAll(){
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public ItemDto findById(@PathVariable Long id) {
        return itemService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {

        itemService.deleteById(id);
    }

    @GetMapping("/")
    public ItemDto findByName(@RequestParam("name") String name) {

        return itemService.findByName(name);
    }
}
