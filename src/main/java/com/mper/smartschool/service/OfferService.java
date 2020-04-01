package com.mper.smartschool.service;

import com.mper.smartschool.dto.OfferDto;

import java.util.Collection;

public interface OfferService {
    OfferDto create(OfferDto categoryDto);

    OfferDto update(OfferDto categoryDto);

    Collection<OfferDto> findAll();

    OfferDto findById(Long id);

    void deleteById(Long id);

}
