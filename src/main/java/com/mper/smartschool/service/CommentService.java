package com.mper.smartschool.service;

import com.mper.smartschool.dto.CommentDto;

import java.util.Collection;

public interface CommentService {
    CommentDto create(CommentDto categoryDto);

    CommentDto update(CommentDto categoryDto);

    Collection<CommentDto> findAll();

    CommentDto findById(Long id);

    void deleteById(Long id);

}
