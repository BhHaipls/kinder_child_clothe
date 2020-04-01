package com.mper.smartschool.service.impl;

import com.mper.smartschool.dto.OfferDto;
import com.mper.smartschool.dto.mapper.OfferMapper;
import com.mper.smartschool.entity.Offer;
import com.mper.smartschool.exception.NotFoundException;
import com.mper.smartschool.repository.OfferRepo;
import com.mper.smartschool.service.OfferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

    @Service
    @Slf4j
    @RequiredArgsConstructor
    public class OfferServiceImpl implements OfferService {

        private final OfferRepo offerRepo;
        private final OfferMapper offerMapper;


        @Override
        public OfferDto create(OfferDto offerDto) {
            Offer offer = offerMapper.toEntyty(offerDto);
            Offer result = offerRepo.save(offer);
            OfferDto resultDto = offerMapper.toDto(result);
            log.info("Offer created successfully: {}",resultDto);
            return resultDto;
        }

        @Override
        public OfferDto update(OfferDto userDto) {
            return null;
        }

        @Override
        public Collection<OfferDto> findAll() {
            Collection<OfferDto> result = offerRepo.findAll()
                    .stream()
                    .map(offerMapper::toDto)
                    .collect(Collectors.toList());
            log.info("IN findAll - {} delyvery found", result.size());
            return result;
        }

        @Override
        public OfferDto findById(Long id) {

            OfferDto result = offerMapper.toDto(offerRepo.findById(id)
                    .orElseThrow(() -> new NotFoundException("OfferNotFoundException.byId", id)));
            log.info("IN findById - offer: {} found by id: {}", result, id);
            return result;

        }

        @Override
        public void deleteById(Long id) {
            findById(id);
            offerRepo.deleteById(id);
            log.info("IN deleteById - offer with id: {} successfully deleted", id);
        }

    }
