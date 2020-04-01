package com.mper.smartschool.service.impl;

import com.mper.smartschool.dto.CommentDto;
import com.mper.smartschool.dto.mapper.CommentMapper;
import com.mper.smartschool.entity.Comment;
import com.mper.smartschool.exception.NotFoundException;
import com.mper.smartschool.repository.CommentRepo;
import com.mper.smartschool.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

    @Service
    @Slf4j
    @RequiredArgsConstructor
    public class CommentServiceImpl implements CommentService {

        private final CommentRepo commentRepo;
        private final CommentMapper commentMapper;


        @Override
        public CommentDto create(CommentDto commentDto) {
            Comment comment = commentMapper.toEntyty(commentDto);
            Comment result = commentRepo.save(comment);
            CommentDto resultDto = commentMapper.toDto(result);
            log.info("Comment created successfully: {}",resultDto);
            return resultDto;
        }

        @Override
        public CommentDto update(CommentDto userDto) {
            return null;
        }

        @Override
        public Collection<CommentDto> findAll() {
            Collection<CommentDto> result = commentRepo.findAll()
                    .stream()
                    .map(commentMapper::toDto)
                    .collect(Collectors.toList());
            log.info("IN findAll - {} delyvery found", result.size());
            return result;
        }

        @Override
        public CommentDto findById(Long id) {

            CommentDto result = commentMapper.toDto(commentRepo.findById(id)
                    .orElseThrow(() -> new NotFoundException("CommentNotFoundException.byId", id)));
            log.info("IN findById - comment: {} found by id: {}", result, id);
            return result;

        }

        @Override
        public void deleteById(Long id) {
            findById(id);
            commentRepo.deleteById(id);
            log.info("IN deleteById - comment with id: {} successfully deleted", id);
        }


}
