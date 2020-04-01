package com.mper.smartschool.controller;

import com.mper.smartschool.dto.CurtDto;
import com.mper.smartschool.service.CurtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequiredArgsConstructor
@RequestMapping("/curt")
public class CurtController {
    private final CurtService curtService;
    @PostMapping
    CurtDto create(CurtDto curtDto){
        return curtService.create(curtDto);
    }

    @GetMapping
    Collection<CurtDto> findAll(){
        return curtService.findAll();
    }

    @GetMapping("/{id}")
    public CurtDto findById(@PathVariable Long id) {
        return curtService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {

        curtService.deleteById(id);
    }


}