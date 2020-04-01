package com.mper.smartschool.controller;

import com.mper.smartschool.dto.OfferDto;
import com.mper.smartschool.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/offer")
public class OfferController {
    private final OfferService offerService;
    @PostMapping
    OfferDto create(OfferDto offerDto){
        return offerService.create(offerDto);
    }

    @GetMapping
    Collection<OfferDto> findAll(){
        return offerService.findAll();
    }

    @GetMapping("/{id}")
    public OfferDto findById(@PathVariable Long id) {
        return offerService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {

        offerService.deleteById(id);
    }


}