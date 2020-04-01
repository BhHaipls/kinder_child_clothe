package com.mper.smartschool.service;

import com.mper.smartschool.dto.CurtDto;

import java.util.Collection;

public interface CurtService {
    CurtDto create(CurtDto categoryDto);

    CurtDto update(CurtDto categoryDto);

    Collection<CurtDto> findAll();

    CurtDto findById(Long id);

    void deleteById(Long id);

}
