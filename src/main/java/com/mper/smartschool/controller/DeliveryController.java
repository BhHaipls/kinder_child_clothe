package com.mper.smartschool.controller;

import com.mper.smartschool.dto.DeliveryDto;
import com.mper.smartschool.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/delivery")
public class DeliveryController {
    private final DeliveryService deliveryService;
    @PostMapping
    DeliveryDto create(DeliveryDto deliveryDto){
        return deliveryService.create(deliveryDto);
    }

    @GetMapping
    Collection<DeliveryDto> findAll(){
        return deliveryService.findAll();
    }

    @GetMapping("/{id}")
    public DeliveryDto findById(@PathVariable Long id) {
        return deliveryService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {

        deliveryService.deleteById(id);
    }

    @GetMapping("/")
    public DeliveryDto findByName(@RequestParam("name") String name) {

        return deliveryService.findByName(name);
    }
}
