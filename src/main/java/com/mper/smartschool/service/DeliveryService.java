package com.mper.smartschool.service;

import com.mper.smartschool.dto.DeliveryDto;

import java.util.Collection;

public interface DeliveryService {

    DeliveryDto create(DeliveryDto deliveryDto);

    DeliveryDto update(DeliveryDto deliveryDto);

    Collection<DeliveryDto> findAll();

    DeliveryDto findById(Long id);

    void deleteById(Long id);

    DeliveryDto findByName(String name);
}
