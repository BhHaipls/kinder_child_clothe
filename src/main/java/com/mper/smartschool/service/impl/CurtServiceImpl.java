package com.mper.smartschool.service.impl;

import com.mper.smartschool.dto.CurtDto;
import com.mper.smartschool.dto.mapper.CurtMapper;
import com.mper.smartschool.entity.Curt;
import com.mper.smartschool.exception.NotFoundException;
import com.mper.smartschool.repository.CurtRepo;
import com.mper.smartschool.service.CurtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

    @Service
    @Slf4j
    @RequiredArgsConstructor
    public class CurtServiceImpl implements CurtService {

        private final CurtRepo curtRepo;
        private final CurtMapper curtMapper;


        @Override
        public CurtDto create(CurtDto curtDto) {
            Curt curt = curtMapper.toEntyty(curtDto);
            Curt result = curtRepo.save(curt);
            CurtDto resultDto = curtMapper.toDto(result);
            log.info("Curt created successfully: {}",resultDto);
            return resultDto;
        }

        @Override
        public CurtDto update(CurtDto userDto) {
            return null;
        }

        @Override
        public Collection<CurtDto> findAll() {
            Collection<CurtDto> result = curtRepo.findAll()
                    .stream()
                    .map(curtMapper::toDto)
                    .collect(Collectors.toList());
            log.info("IN findAll - {} delyvery found", result.size());
            return result;
        }

        @Override
        public CurtDto findById(Long id) {

            CurtDto result = curtMapper.toDto(curtRepo.findById(id)
                    .orElseThrow(() -> new NotFoundException("CurtNotFoundException.byId", id)));
            log.info("IN findById - curt: {} found by id: {}", result, id);
            return result;

        }

        @Override
        public void deleteById(Long id) {
            findById(id);
            curtRepo.deleteById(id);
            log.info("IN deleteById - curt with id: {} successfully deleted", id);
        }


    }
