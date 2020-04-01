package com.mper.smartschool.service.impl;

import com.mper.smartschool.dto.DeliveryDto;
import com.mper.smartschool.dto.mapper.DeliveryMapper;
import com.mper.smartschool.entity.Delivery;
import com.mper.smartschool.exception.NotFoundException;
import com.mper.smartschool.repository.DeliveryRepo;
import com.mper.smartschool.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepo deliveryRepo;
    private final DeliveryMapper deliveryMapper;


    @Override
    public DeliveryDto create(DeliveryDto deliveryDto) {
        Delivery delivery = deliveryMapper.toEntyty(deliveryDto);
        Delivery result = deliveryRepo.save(delivery);
        DeliveryDto resultDto = deliveryMapper.toDto(result);
        log.info("Delivery created successfully: {}",resultDto);
        return resultDto;
    }

    @Override
    public DeliveryDto update(DeliveryDto userDto) {
        return null;
    }

    @Override
    public Collection<DeliveryDto> findAll() {
        Collection<DeliveryDto> result = deliveryRepo.findAll()
                .stream()
                .map(deliveryMapper::toDto)
                .collect(Collectors.toList());
        log.info("IN findAll - {} delyvery found", result.size());
        return result;
    }

    @Override
    public DeliveryDto findById(Long id) {

        DeliveryDto result = deliveryMapper.toDto(deliveryRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("DeliveryNotFoundException.byId", id)));
        log.info("IN findById - delivery: {} found by id: {}", result, id);
        return result;

    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        deliveryRepo.deleteById(id);
        log.info("IN deleteById - delivery with id: {} successfully deleted", id);
    }

    @Override
    public DeliveryDto findByName(String name) {
        DeliveryDto result = deliveryMapper.toDto(deliveryRepo.findByName(name)
                .orElseThrow(() -> new NotFoundException("UserNotFoundException.byName", name)));
        log.info("IN findByName - user: {} found by name: {}", result, name);
        return result;
    }
}
